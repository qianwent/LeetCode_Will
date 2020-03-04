package com.javaadvanced.multithread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockInterrupt {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    Thread thread1 = new Thread(new Task(lock1, lock2));
    Thread thread2 = new Thread(new Task(lock2, lock1));

    public static void main(String[] args) {
        ReentrantLockInterrupt reentrantLockInterrupt = new ReentrantLockInterrupt();
        reentrantLockInterrupt.thread1.start();
        reentrantLockInterrupt.thread2.start();
//        reentrantLockInterrupt.thread1.interrupt();
    }

    class Task implements Runnable {

        Lock lock1;
        Lock lock2;

        public Task(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            try {
                /**
                 * 搞清楚这里在干什么，这是非常基础的死锁
                 * 首先很明确，两个线程能同时执行这个方法，那么要死锁就要让线程1把lock1锁定
                 * 然后让线程2把lock2锁定
                 * 这里就能很好理解为什么要在lock1锁定之后sleep一会儿了，为的就是让thread2尽快把lock2锁定住
                 * 注意，依然不要想当然，thread2进来的时候还是在执行lock1.lockInterruptibly();但实际上这里传进来的是lock2
                 * 所以当线程1苏醒后，想要拿lock2，发现拿不到了
                 */
                System.out.println(Thread.currentThread().getName());
                lock1.lockInterruptibly();
                TimeUnit.MILLISECONDS.sleep(50);
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
                System.out.println(Thread.currentThread().getName() + " get the lock, normal...");
            }
        }
    }
}

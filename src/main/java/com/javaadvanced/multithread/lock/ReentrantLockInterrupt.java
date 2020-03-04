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
                 * ����������ڸ�ʲô�����Ƿǳ�����������
                 * ���Ⱥ���ȷ�������߳���ͬʱִ�������������ôҪ������Ҫ���߳�1��lock1����
                 * Ȼ�����߳�2��lock2����
                 * ������ܺܺ����ΪʲôҪ��lock1����֮��sleepһ����ˣ�Ϊ�ľ�����thread2�����lock2����ס
                 * ע�⣬��Ȼ��Ҫ�뵱Ȼ��thread2������ʱ������ִ��lock1.lockInterruptibly();��ʵ�������ﴫ��������lock2
                 * ���Ե��߳�1���Ѻ���Ҫ��lock2�������ò�����
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

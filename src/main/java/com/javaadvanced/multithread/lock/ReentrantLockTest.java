package com.javaadvanced.multithread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock(true);

    public static void test() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get the lock");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " release the lock");
            lock.unlock();
        }
    }

    public static void test2() {
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                System.out.println(Thread.currentThread().getName() + " release the lock");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(()->test(), "thread1").start();
//        new Thread(()->test(), "thread2").start();

        /**
         * if default constructor of ReentrantLock -> NonfairSync
         * if passing true -> FairSync
         * behaviors are quite different
         */
        new Thread(()->test2(), "thread1").start();
        new Thread(()->test2(), "thread2").start();
        new Thread(()->test2(), "thread3").start();
        new Thread(()->test2(), "thread4").start();
        new Thread(()->test2(), "thread5").start();
    }
}

package com.javaadvanced.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TwoThreadsWithExecutorService {

    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Object LOCK2 = new Object();
        int MAX = 10;


        Thread thread3 = new Thread() {
            @Override
            public void run() {
                while (i < MAX) {
                    synchronized (LOCK2) {
                        if (i % 2 == 0) {
                            System.out.println(i++);
                        } else {
                            LOCK2.notifyAll();
                            try {
                                LOCK2.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
//                Thread.interrupted();
            }
        };

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                while (i < MAX) {
                    synchronized (LOCK2) {
                        if (i % 2 == 1) {
                            System.out.println(i++);
                            if (i == MAX) {
                                LOCK2.notifyAll();//this is to notify the other thread to stop waiting
                            }
                        } else {
                            LOCK2.notifyAll();
                            try {
                                LOCK2.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
//                Thread.interrupted();
            }
        };

        ExecutorService service2 = Executors.newFixedThreadPool(2);
        Future task3 = service2.submit(thread3);
        Future task4 = service2.submit(thread4);
        System.out.println("task3 done ? " + task3.isDone());//this could be executed before service.submit
        System.out.println("task4 done ? " + task4.isDone());
        service2.shutdown();
        service2.awaitTermination(500, TimeUnit.MILLISECONDS);
        service2.shutdownNow();
    }
}

package com.javaadvanced.multithread;

public class TwoThreads {

    public static int i = 0;

    public static void main(String[] args) {

        Object LOCK = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                /**
                 * synchronized outside of for loop seems work, inside is not correct, when using executor service...
                 * the lock should be the same object here, if use this, then they are actually different object...
                 */
                synchronized (LOCK) {
                    System.out.println("t1 LOCK - " + LOCK);
                    System.out.println("t1 this - " + this);
                    for (int i = 0; i < 100; i++) {
                        if (i % 2 == 0) {
                            System.out.println(i);
                        } else {
                            LOCK.notifyAll();
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
//                Thread.interrupted();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    System.out.println("t2 LOCK - " + LOCK);
                    System.out.println("t2 this - " + this);
                    for (int i = 1; i <= 100; i++) {
                        if (i == 100) {
                            LOCK.notifyAll();
                            System.out.println("--- " + Thread.activeCount());
                            break;//stop the loop here, otherwise enter into else logic, and block the thread...
                        }
                        if (i % 2 == 1) {
                            System.out.println(i);
                        } else {
                            LOCK.notifyAll();
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
//                Thread.interrupted();
            }
        };

//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    synchronized (LOCK) {
//                        if (i % 2 == 0) {
//                            System.out.println(i);
//                        } else {
//                            LOCK.notifyAll();
//                            try {
//                                LOCK.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 100; i++) {
//                    synchronized (LOCK) {
//                        if (i % 2 == 1) {
//                            System.out.println(i);
//                        } else {
//                            LOCK.notifyAll();
//                            try {
//                                LOCK.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        };

        thread1.start();
        thread2.start();


//        ExecutorService service = Executors.newFixedThreadPool(2);
//        Future task1 = service.submit(thread1);
//        Future task2 = service.submit(thread2);
//        task1.get();
////        task2.get();
//        System.out.println("task1 done ? " + task1.isDone());
//        System.out.println("task2 done ? " + task2.isDone());
//        service.shutdown();
//        service.awaitTermination(500, TimeUnit.MILLISECONDS);
//        service.shutdownNow();

    }
}

package com.javaadvanced.multithread;

public class TwoThreads {

    public static void main(String[] args) {

        Object LOCK = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                /**
                 * synchronized inside or outside of for loop doesn't matter
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
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    System.out.println("t2 LOCK - " + LOCK);
                    System.out.println("t2 this - " + this);
                    for (int i = 1; i < 100; i++) {
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
    }
}

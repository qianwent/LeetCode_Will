package com.javaadvanced.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LimitRate {

    public static void main(String[] args) {

        RateLimiter rateLimiter = RateLimiter.create(1);
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new UserRequest(i));
        }

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (Runnable runnable : tasks) {
            System.out.println("waiting time: " + rateLimiter.acquire());
            threadPool.execute(runnable);
        }
        if (!threadPool.isShutdown()) {
            threadPool.shutdown();
        }
    }

    static class UserRequest implements Runnable {

        int id;

        public UserRequest(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("user : " + id + "executed");
        }
    }
}

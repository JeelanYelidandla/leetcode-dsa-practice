package com.leetcode.resilience;

import java.util.concurrent.*;

public class TimeoutExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(3000); // simulate slow call
            return "Service response";
        });

        try {
            String result = future.get(1, TimeUnit.SECONDS); // 1s timeout
            System.out.println("Got response: " + result);
        } catch (TimeoutException e) {
            System.out.println("Request timed out");
        } catch (Exception e) {
            System.out.println("Request failed");
        }

        executor.shutdown();
    }
}

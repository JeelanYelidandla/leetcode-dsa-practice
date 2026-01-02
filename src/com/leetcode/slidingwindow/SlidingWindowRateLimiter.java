package com.leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowRateLimiter {

    // Configuration
    private final int limit;              // max allowed requests per window
    private final long windowSizeMillis;  // window duration in milliseconds
    private final Deque<Long> timestamps; // stores timestamps of recent requests

    // Constructor
    public SlidingWindowRateLimiter(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
        this.timestamps = new ArrayDeque<>();
    }

    // Core method: check if request is allowed
    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Step 1: Remove expired timestamps (older than current_time - window_size)
        while (!timestamps.isEmpty() && now - timestamps.peekFirst() >= windowSizeMillis) {
            timestamps.pollFirst(); // remove oldest request
        }

        // Step 2: Check if within limit
        if (timestamps.size() < limit) {
            timestamps.addLast(now); // record this request
            return true; // ✅ Allowed
        } else {
            return false; // ❌ Dropped
        }
    }

    // Simple simulation
    public static void main(String[] args) throws InterruptedException {
        // Example: 10 requests per 60 seconds
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(10, 60_000);

        // Simulate 15 incoming requests, some spaced, some rapid
        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.allowRequest();
            String status = allowed ? "✅ Allowed" : "❌ Dropped";
            System.out.printf("[%02d] %s at %d ms%n", i, status, System.currentTimeMillis() % 100000);
            
            // Simulate time gap between requests
            Thread.sleep(i % 3 == 0 ? 2000 : 500); // some requests closer, some farther apart
        }

        // Wait and try again after 1 minute (old timestamps expire)
        System.out.println("\nWaiting 1 minute for old requests to expire...\n");
        Thread.sleep(61_000);

        for (int i = 16; i <= 18; i++) {
            boolean allowed = limiter.allowRequest();
            String status = allowed ? "✅ Allowed" : "❌ Dropped";
            System.out.printf("[%02d] %s at %d ms%n", i, status, System.currentTimeMillis() % 100000);
        }
    }
}

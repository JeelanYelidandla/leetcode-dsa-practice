package com.leetcode.resilience;

/*
1. Fixed Window

Counts requests in a fixed interval (e.g., 1 min).

If limit = 10 and 15 requests come in → 10 pass (green), 5 dropped (red).

❌ Problem: Bursts at window boundaries.
 */
public class RateLimitFixedWindow {
    private static final int LIMIT = 5; // Max requests per window
    private static final long WINDOW_SIZE_MS = 1000; // 1 second
    private int count = 0;
    private long windowStart = System.currentTimeMillis();

    public boolean allowRequest() {
        long now = System.currentTimeMillis();
        if (now - windowStart >= WINDOW_SIZE_MS) {
            // Reset window
            windowStart = now;
            count = 0;
        }
        if (count < LIMIT) {
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimitFixedWindow limiter = new RateLimitFixedWindow();
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + (limiter.allowRequest() ? "Allowed" : "Rejected"));
            Thread.sleep(200);
        }
    }
}

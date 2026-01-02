package com.leetcode.resilience;

import java.util.*;
/*
2. Sliding Window

Uses a rolling time window (e.g., last 60s).

Counts requests more fairly, preventing sudden bursts.

✅ More accurate than fixed window.
 */
public class RateLimitSlidingWindow {
    private static final int LIMIT = 5;
    private static final long WINDOW_SIZE_MS = 1000; // 1 sec
    private Queue<Long> requests = new LinkedList<>();

    public boolean allowRequest() {
        long now = System.currentTimeMillis();
        // Remove requests older than window
        while (!requests.isEmpty() && now - requests.peek() >= WINDOW_SIZE_MS) {
            requests.poll();
        }
        if (requests.size() < LIMIT) {
            requests.add(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimitSlidingWindow limiter = new RateLimitSlidingWindow();
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + (limiter.allowRequest() ? "Allowed" : "Rejected"));
            Thread.sleep(200);
        }
    }
}

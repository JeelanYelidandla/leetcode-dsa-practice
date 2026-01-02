package com.leetcode.resilience;

import java.util.*;
/*
4. Leaky Bucket

Incoming requests go into a bucket.

They leak out at a fixed rate (green line).

❌ Excess (burst traffic in red) is discarded.

✅ Ensures smooth, constant processing.
 */
public class RateLimitLeakyBucket {
    private static final int CAPACITY = 5;
    private static final long LEAK_INTERVAL_MS = 1000; // 1 req/sec leak
    private Queue<Long> bucket = new LinkedList<>();

    public boolean allowRequest() {
        long now = System.currentTimeMillis();
        // Leak old requests
        while (!bucket.isEmpty() && now - bucket.peek() > LEAK_INTERVAL_MS) {
            bucket.poll();
        }
        if (bucket.size() < CAPACITY) {
            bucket.add(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimitLeakyBucket limiter = new RateLimitLeakyBucket();
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + (limiter.allowRequest() ? "Allowed" : "Rejected"));
            Thread.sleep(200);
        }
    }
}

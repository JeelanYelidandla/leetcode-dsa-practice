package com.leetcode.resilience;

/**
 * Goal:
 * Control the rate of requests by slowing down (instead of blocking or rejecting like in rate limiting).
 */
public class Throttler {
    private final long intervalMillis;
    private long lastRequestTime = 0;

    public Throttler(int requestsPerSecond) {
        this.intervalMillis = 1000L / requestsPerSecond;
    }

    public synchronized void throttle() {
        long now = System.currentTimeMillis();
        long waitTime = lastRequestTime + intervalMillis - now;

        if (waitTime > 0) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ignored) {}
        }
        lastRequestTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Throttler throttler = new Throttler(2); // 2 requests per second

        for (int i = 1; i <= 10; i++) {
            throttler.throttle(); // delay if needed
            System.out.println("Processing request " + i + " at " + System.currentTimeMillis());
        }
    }
}

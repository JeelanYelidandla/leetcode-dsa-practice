package com.leetcode.resilience;

/*
3. Token Bucket

Tokens refill at a steady rate.

Requests consume tokens; if bucket is empty → drop request.

✅ Allows bursts if tokens were saved up.
 */
public class RateLimitTokenBucket {
    private static final int CAPACITY = 5;
    private static final int REFILL_RATE = 1; // tokens per second
    private int tokens = CAPACITY;
    private long lastRefill = System.currentTimeMillis();

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = (now - lastRefill) / 1000; // seconds passed
        if (elapsed > 0) {
            int refillTokens = (int) (elapsed * REFILL_RATE);
            tokens = Math.min(CAPACITY, tokens + refillTokens);
            lastRefill = now;
        }
    }

    public boolean allowRequest() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimitTokenBucket limiter = new RateLimitTokenBucket();
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + (limiter.allowRequest() ? "Allowed" : "Rejected"));
            Thread.sleep(200);
        }
    }
}

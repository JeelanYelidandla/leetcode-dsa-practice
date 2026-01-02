package com.leetcode.resilience;

public class RetryWithBackoff {
    public static String callService() throws Exception {
        if (Math.random() < 0.7) throw new Exception("Temporary error");
        return "Success!";
    }

    public static void main(String[] args) {
        int maxRetries = 3;
        int attempt = 0;
        long backoff = 1000;

        while (attempt < maxRetries) {
            try {
                String result = callService();
                System.out.println("Result: " + result);
                break;
            } catch (Exception e) {
                attempt++;
                System.out.println("Attempt " + attempt + " failed. Retrying...");
                try { Thread.sleep(backoff); } catch (InterruptedException ignored) {}
                backoff *= 2; // exponential backoff
            }
        }
    }
}

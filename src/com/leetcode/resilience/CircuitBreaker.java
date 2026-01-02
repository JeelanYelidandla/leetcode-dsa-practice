package com.leetcode.resilience;

public class CircuitBreaker {

    private static final int FAILURE_THRESHOLD = 3;
    private int failureCount = 0;
    private boolean isOpen = false;

    public String callService() {
        if (isOpen)
            return "Circuit is open. Request blocked.";
        try {
            simulateFailure();
            failureCount = 0;
            return "Service call succeeded.";
        } catch (Exception e) {
            failureCount++;
            if (failureCount >= FAILURE_THRESHOLD) {
                isOpen = true;
            }
            return "Service call failed.";
        }
    }

    private void simulateFailure() throws Exception {
        var num = Math.round(Math.random());
        System.out.println("NUMBER " + num);
        if (num < 0.6) throw new Exception("Simulated failure");
    }

    public static void main(String[] args) {
        CircuitBreaker cb = new CircuitBreaker();
        for (int i = 0; i < 10; i++) {
            System.out.println("Call " + i + ": " + cb.callService());
        }
    }
}

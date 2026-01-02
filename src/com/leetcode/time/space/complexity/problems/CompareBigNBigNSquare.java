package com.leetcode.time.space.complexity.problems;

public class CompareBigNBigNSquare {

    public static void main(String[] args) {
        int n = 20;  // Try with 10, 100, etc. for scaling
        int stepCounter = 0;

        // ✅ SEPARATE LOOPS: O(n) + O(n)
        System.out.println("=== Separate Loops ===");
        // First loop
        for (int i = 0; i < n; i++) {
            stepCounter++;
            System.out.println("First loop i = " + i);
        }

        // Second loop
        for (int j = 0; j < n; j++) {
            stepCounter++;
            System.out.println("Second loop j = " + j);
        }

        System.out.println("Total steps (separate loops): " + stepCounter);
        System.out.println("Expected: O(n) — because 2n steps simplifies to n");

        System.out.println("\n=== Nested Loops ===");
        stepCounter = 0;

        // ❌ NESTED LOOPS: O(n²)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stepCounter++;
                System.out.println("Nested loop: i = " + i + ", j = " + j);
            }
        }

        System.out.println("Total steps (nested loops): " + stepCounter);
        System.out.println("Expected: O(n²) — because n * n steps");
    }
}


package com.leetcode.binarysearch;

import java.util.*;
// this one available in jeelan.yelidandla account in chatgpt
class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Step 1: Sort by start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Iterate and merge
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Check for overlap: → merge: Extend the current interval's end time to the maximum of the two end times
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap → add new interval: The current interval is finalized, so start a new one
                current = interval;
                merged.add(current);
            }
        }
        // Step 3: Convert the List<int[]> back to int[][]
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Main method for testing the MergeIntervals class.
     */
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        // --- Test Case 1: Standard merge ---
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] result1 = solution.merge(intervals1);
        System.out.println("Test Case 1: Input: [[1,3],[2,6],[8,10],[15,18]]");
        System.out.print("           Output: ");
//        printIntervals(result1); // Expected: [[1,6],[8,10],[15,18]]

        // --- Test Case 2: Full overlap ---
        int[][] intervals2 = {{1, 4}, {4, 5}}; // [1,4] and [4,5] merge to [1,5]
//        int[][] result2 = solution.merge(intervals2);
        System.out.println("\nTest Case 2: Input: [[1,4],[4,5]]");
        System.out.print("           Output: ");
//        printIntervals(result2); // Expected: [[1,5]]

        // --- Test Case 3: No merge needed (already sorted and disjoint) ---
        int[][] intervals3 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result3 = solution.merge(intervals3);
        System.out.println("\nTest Case 3: Input: [[1,2],[3,4],[5,6]]");
        System.out.print("           Output: ");
        printIntervals(result3); // Expected: [[1,2],[3,4],[5,6]]

        // --- Test Case 4: Complete containment ---
        int[][] intervals4 = {{1, 10}, {2, 5}, {6, 8}};
        int[][] result4 = solution.merge(intervals4);
        System.out.println("\nTest Case 4: Input: [[1,10],[2,5],[6,8]]");
        System.out.print("           Output: ");
        printIntervals(result4); // Expected: [[1,10]]

        // --- Test Case 5: Empty input ---
        int[][] intervals5 = {};
        int[][] result5 = solution.merge(intervals5);
        System.out.println("\nTest Case 5: Input: []");
        System.out.print("           Output: ");
        printIntervals(result5); // Expected: []
    }

    /**
     * Helper method to print the 2D array of intervals in a readable format.
     */
    public static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(Arrays.toString(intervals[i]));
            if (i < intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

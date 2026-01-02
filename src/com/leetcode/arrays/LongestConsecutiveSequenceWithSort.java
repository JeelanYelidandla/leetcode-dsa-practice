package com.leetcode.arrays;

import java.util.Arrays;

public class LongestConsecutiveSequenceWithSort {
/*
    Approach 2 — Sort then scan (O(n log n) time, O(1) or O(n) extra)
    Sort the array.
    Scan once, skipping duplicates; maintain currentLen and maxLen.
    Simpler to reason but slower for large n.
*/
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int best = 1, curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                continue; // skip duplicate
            else if (nums[i] == nums[i-1] + 1) {
                curLen++;
            } else {
                best = Math.max(best, curLen);
                curLen = 1;
            }
        }
        return Math.max(best, curLen);
    }

    static void main() {
        System.out.println(LongestConsecutiveSequenceWithSort.longestConsecutive(new int [] {100, 4, 200, 1, 3, 2}));
    }
}

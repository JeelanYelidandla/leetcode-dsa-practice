package com.leetcode.arrays;

import java.util.*;

public class LongestConsecutiveSequence {
/*
    Idea:

    Put all numbers into a HashSet for O(1) lookups.
    For each number x, only start counting if x-1 is not in set (i.e., x is the start of a sequence).
    Then increment current = x, and while current+1 is in set, increment and count.
    Track maxLen.
    Why this is O(n): Each number is visited at most twice (once to test if it's a sequence start,
    once in the inner while across whole run), so overall linear.


 */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    static void main() {
        System.out.println(LongestConsecutiveSequence.longestConsecutive(new int [] {100, 4, 200, 1, 3, 2}));
    }
}

package com.leetcode.slidingwindow;

import java.util.*;

public class PermutationInStringHashMap {

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        // Step 1: build frequency for s1 and first window of s2
        for (int i = 0; i < m; i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s1Count.equals(s2Count)) return true;

        // Step 2: slide the window across s2
        for (int i = m; i < n; i++) {
            // add new char entering window
            char addChar = s2.charAt(i);
            s2Count.put(addChar, s2Count.getOrDefault(addChar, 0) + 1);

            // remove old char leaving window
            char removeChar = s2.charAt(i - m);
            s2Count.put(removeChar, s2Count.get(removeChar) - 1);
            if (s2Count.get(removeChar) == 0) {
                s2Count.remove(removeChar); // keep map clean
            }

            // compare maps
            if (s1Count.equals(s2Count)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInStringHashMap sol = new PermutationInStringHashMap();

        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "eidboaoo";

        System.out.println(sol.checkInclusion(s1, s2)); // true
        System.out.println(sol.checkInclusion(s1, s3)); // false
    }
}

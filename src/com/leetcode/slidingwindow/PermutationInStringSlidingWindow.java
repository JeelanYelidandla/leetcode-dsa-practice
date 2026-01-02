package com.leetcode.slidingwindow;

import java.util.Arrays;

public class PermutationInStringSlidingWindow {

    public boolean checkInclusion(String s1, String s2) {
        int s1Lenght = s1.length();
        int s2Lenght = s2.length();
        if (s1Lenght > s2Lenght)
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Step 1: Count frequency for s1 and first window of s2
        for (int i = 0; i < s1Lenght; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Step 2: Check initial window
        if (Arrays.equals(s1Count, s2Count)) return true;

        // Step 3: Slide the window across s2
        for (int i = s1Lenght; i < s2Lenght; i++) {
            s2Count[s2.charAt(i) - 'a']++;       // add new char
            s2Count[s2.charAt(i - s1Lenght) - 'a']--;   // remove old char

            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInStringSlidingWindow sol = new PermutationInStringSlidingWindow();

        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "eidboaoo";

        System.out.println(sol.checkInclusion(s1, s2)); // true
        System.out.println(sol.checkInclusion(s1, s3)); // false
    }
}

package com.leetcode.slidingwindow;

public class LongestRepeatingCharacterReplacement {

/*
Dry Run on "ABAB", k=2

| Step | `right` | Char | Update freq | `maxCount` | Window `[left..right]` | Window size | Replacements `(size - maxCount)` | Condition > k? | Action | `maxLength` |
| ---- | ------- | ---- | ----------- | ---------- | ---------------------- | ----------- | -------------------------------- | -------------- | ------ | ----------- |
| 1    | 0       | A    | freq[A]=1   | 1          | [0..0] `"A"`           | 1           | 1-1=0                            | 0 ≤ 2 ✅        | keep   | 1           |
| 2    | 1       | B    | freq[B]=1   | 1          | [0..1] `"AB"`          | 2           | 2-1=1                            | 1 ≤ 2 ✅        | keep   | 2           |
| 3    | 2       | A    | freq[A]=2   | 2          | [0..2] `"ABA"`         | 3           | 3-2=1                            | 1 ≤ 2 ✅        | keep   | 3           |
| 4    | 3       | B    | freq[B]=2   | 2          | [0..3] `"ABAB"`        | 4           | 4-2=2                            | 2 ≤ 2 ✅        | keep   | 4           |

🔹 Dry Run on "ABCDE", k=3

| Step | `right` index | Char | freq[...] update | `maxCount` | Window `[left..right]` | Window size | Condition `(size - maxCount > k)` | Action | `maxLength` |
| ---- | ------------- | ---- | ---------------- | ---------- | ---------------------- | ----------- | --------------------------------- | ------ | ----------- |
| 1    | 0             | A    | freq[A]=1        | 1          | [0..0] `"A"`           | 1           | 1-1=0 ≤ 3 ✅                       | keep   | 1           |
| 2    | 1             | B    | freq[B]=1        | 1          | [0..1] `"AB"`          | 2           | 2-1=1 ≤ 3 ✅                       | keep   | 2           |
| 3    | 2             | C    | freq[C]=1        | 1          | [0..2] `"ABC"`         | 3           | 3-1=2 ≤ 3 ✅                       | keep   | 3           |
| 4    | 3             | D    | freq[D]=1        | 1          | [0..3] `"ABCD"`        | 4           | 4-1=3 ≤ 3 ✅                       | keep   | 4           |
| 5    | 4             | E    | freq[E]=1        | 1          | [0..4] `"ABCDE"`       | 5           | 5-1=4 > 3 ❌                       | shrink | still 4     |

Problem

You are given a string s and an integer k. You can replace at most k characters in the string with any character.
Find the length of the longest substring containing the same letter after at most k replacements.

Approach (Sliding Window)
    Use a sliding window with two pointers (left and right).
    Track character frequencies in the window using an array or map.
    Keep track of the max frequency of any character in the current window.
    If (window size - maxFreq) > k, shrink the window from the left.
    Update the answer as the maximum window length seen so far.


🔹 Approach

    Maintain a sliding window (left, right).
    Use an array count[26] to track frequency of characters in the window.
    Track maxCount = frequency of the most common character in the window.
    If (window size - maxCount) > k, shrink from left (because too many replacements are needed).
    Keep track of the maximum valid window size.

 */
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;   // frequency of the most common character in the current window
        int maxLength = 0;  // length of the longest valid window found so far

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("BABCA", 2));   // 4
//        System.out.println(characterReplacement("AABABBA", 1)); // 4
//        System.out.println(characterReplacement("ABCDE", 2));   // 3
    }
}

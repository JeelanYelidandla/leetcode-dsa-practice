package com.leetcode.slidingwindow;

import java.io.IO;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

/*
Here left and right pointers are pointing at same index. i.e. staring index from string.

📌 Problem Statement

Given a string s, find the length of the longest substring without repeating characters.
    Examples:
    Input: s = "abcabcbb" → Output: 3 ("abc")
    Input: s = "bbbbb" → Output: 1 ("b")
    Input: s = "pwwkew" → Output: 3 ("wke")

🔑 Intuition: Understanding Verbal
    This is a classic sliding window problem.
    Maintain a window [left, right] that always contains unique characters.
    Expand right → to add new characters.
    If a duplicate appears → shrink left until the duplicate is removed.
    Keep track of the maximum window length at each step.
    Use a HashSet (or HashMap) to quickly check duplicates.

✍️ Pseudo-code
Initialize HashSet<Character> window
left = 0, maxLength = 0

for right = 0 to s.length - 1:
    while s[right] is in window:
        remove s[left] from window
        left++
    add s[right] to window
    maxLength = max(maxLength, right - left + 1)

return maxLength


⏱ Complexity
Time: O(n)
    Each character is inserted once and removed once → linear.
Space: O(min(n, charset))
    Depends on character set size (ASCII → 128, lowercase only → 26).

🔑 Key Takeaways
Sliding window = expand with right, shrink with left.
Use HashSet/Map to maintain constraint.
Very reusable template for substring / subarray type problems.

Trace Table

| Step | right | left | char | Operation                                                                            | Time per operation         | Space impact  |
| ---- | ----- | ---- | ---- | ------------------------------------------------------------------------------------ | -------------------------- | ------------- |
| 1    | 0     | 0    | a    | add `a` to set                                                                       | O(1)                       | +1 element    |
| 2    | 1     | 0    | b    | add `b`                                                                              | O(1)                       | +1 element    |
| 3    | 2     | 0    | c    | add `c`                                                                              | O(1)                       | +1 element    |
| 4    | 3     | 0    | a    | duplicate → remove `a` at left=0                                                     | O(1)                       | no net change |
|      |       | 1    |      | then add `a`                                                                         | O(1)                       | stays size 3  |
| 5    | 4     | 1    | b    | duplicate → remove `b` at left=1                                                     | O(1)                       | no net change |
|      |       | 2    |      | then add `b`                                                                         | O(1)                       | stays size 3  |
| 6    | 5     | 2    | c    | duplicate → remove `c` at left=2                                                     | O(1)                       | no net change |
|      |       | 3    |      | then add `c`                                                                         | O(1)                       | stays size 3  |
| 7    | 6     | 3    | b    | duplicate → remove `a` (left=3), still duplicate → remove `b` (left=4), then add `b` | each remove O(1), add O(1) | size ≤ 3      |
| 8    | 7     | 5    | b    | duplicate → remove `c` (left=5), remove `b` (left=6), then add `b`                   | each remove O(1), add O(1) | size ≤ 2      |


🔑 Why right - left + 1?

left and right are indices (0-based).

The current window is the substring from left to right inclusive.

Length of that substring = (last index – first index + 1).

Example: window [2..4] → elements = {c, d, e} → length = 3 = (4 - 2 + 1).

So the formula is just “inclusive length of window”.

🧠 How to Remember It

Here are 3 memory tricks:

1. Window Frame Analogy 🪟

    Think of [left, right] as a window frame on top of the string.
    The width of the window = distance between ends.
    Since indices are inclusive, we need +1 for the width.
    👉 “Distance + 1 = size of the window.”

2. Finger Trick ✋
    Put one finger on index 2, another finger on index 5.
    How many characters are under your fingers? (2, 3, 4, 5 → 4 chars).
    Formula: 5 - 2 + 1 = 4.
    👉 Always add +1 because you’re counting both ends.

3. Template Rule 📑
    For any sliding window code:
    while (condition broken) shrink from left
    // after fixing, update result
    result = Math.max(result, right - left + 1);

So the +1 is always there when both left and right are inclusive pointers.
(If we used half-open [left, right) convention, we wouldn’t need +1 — but most coding interviews use inclusive indices).
 */


    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> windowSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
//            IO.println("inside for loop: START "+ s.charAt(right));
            while (windowSet.contains(s.charAt(right))) {
                windowSet.remove(s.charAt(left));
                left++;
//                IO.println("inside while loop: "+ s.charAt(left));
            }
            windowSet.add(s.charAt(right));
//            IO.println("inside for loop: END "+ s.charAt(right));
//            IO.println("MAP:+" + windowSet);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        IO.println("Final Longest Substring Without Repeating:"+ windowSet);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
//        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
//        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}

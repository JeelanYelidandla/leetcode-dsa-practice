package com.leetcode.string;

import java.util.HashMap;

public class ValidAnagramMap {
    /*
    | Algorithm                 | Best Case  | Average Case | Worst Case | Space Complexity | Notes                                                   |
| ------------------------- | ---------- | ------------ | ---------- | ---------------- | ------------------------------------------------------- |
| **Bubble Sort**           | O(n)       | O(n²)        | O(n²)      | O(1)             | Rarely used, only for teaching                          |
| **Selection Sort**        | O(n²)      | O(n²)        | O(n²)      | O(1)             | Always quadratic                                        |
| **Insertion Sort**        | O(n)       | O(n²)        | O(n²)      | O(1)             | Good for nearly sorted data                             |
| **Merge Sort**            | O(n log n) | O(n log n)   | O(n log n) | O(n)             | Stable, guaranteed performance                          |
| **Quick Sort**            | O(n log n) | O(n log n)   | O(n²)      | O(log n)         | Fast in practice, worst-case avoided with randomization |
| **Heap Sort**             | O(n log n) | O(n log n)   | O(n log n) | O(1)             | Not stable, but in-place                                |
| **Counting Sort**         | O(n+k)     | O(n+k)       | O(n+k)     | O(k)             | Works only with integers in a limited range             |
| **Radix Sort**            | O(nk)      | O(nk)        | O(nk)      | O(n+k)           | Non-comparison, uses Counting Sort as subroutine        |
| **Bucket Sort**           | O(n+k)     | O(n+k)       | O(n²)      | O(n)             | Depends on distribution of input                        |
| **Timsort (Java/Python)** | O(n)       | O(n log n)   | O(n log n) | O(n)             | Hybrid of Merge + Insertion, used in real languages     |
| Algorithm                 | Best Case  | Average Case | Worst Case | Space Complexity | Notes                                                   |
| ------------------------- | ---------- | ------------ | ---------- | ---------------- | ------------------------------------------------------- |
| **Bubble Sort**           | O(n)       | O(n²)        | O(n²)      | O(1)             | Rarely used, only for teaching                          |
| **Selection Sort**        | O(n²)      | O(n²)        | O(n²)      | O(1)             | Always quadratic                                        |
| **Insertion Sort**        | O(n)       | O(n²)        | O(n²)      | O(1)             | Good for nearly sorted data                             |
| **Merge Sort**            | O(n log n) | O(n log n)   | O(n log n) | O(n)             | Stable, guaranteed performance                          |
| **Quick Sort**            | O(n log n) | O(n log n)   | O(n²)      | O(log n)         | Fast in practice, worst-case avoided with randomization |
| **Heap Sort**             | O(n log n) | O(n log n)   | O(n log n) | O(1)             | Not stable, but in-place                                |
| **Counting Sort**         | O(n+k)     | O(n+k)       | O(n+k)     | O(k)             | Works only with integers in a limited range             |
| **Radix Sort**            | O(nk)      | O(nk)        | O(nk)      | O(n+k)           | Non-comparison, uses Counting Sort as subroutine        |
| **Bucket Sort**           | O(n+k)     | O(n+k)       | O(n²)      | O(n)             | Depends on distribution of input                        |
| **Timsort (Java/Python)** | O(n)       | O(n log n)   | O(n log n) | O(n)             | Hybrid of Merge + Insertion, used in real languages     |

🔥 Top Sorting Algorithms to Prepare for Interviews

QuickSort

Time:

Best: O(n log n)

Average: O(n log n)

Worst: O(n²) (if pivot chosen poorly)

Space: O(log n) (recursion stack)

🔑 Why: Classic divide & conquer, commonly asked.

MergeSort

Time: Always O(n log n) (best, avg, worst)

Space: O(n) (extra array for merging)

🔑 Why: Stable sort, often used in linked lists.

HeapSort

Time: Always O(n log n)

Space: O(1) auxiliary space

🔑 Why: Good to know for in-place sorting without recursion.

Counting Sort / Radix Sort / Bucket Sort (non-comparison-based)

Time: O(n + k) (where k = range of input)

Space: O(k)

🔑 Why: Used when numbers fall in a small range (interviewers like to see if you can optimize beyond O(n log n) when conditions allow).

✅ My recommendation (Priority order for interviews)

QuickSort → must master (partition logic + pivot choice)

MergeSort → stable, linked list case

HeapSort → in-place, compare vs quicksort

Counting/Radix → for integer range questions
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        // Count characters in s
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Subtract counts using t
        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c))
                return false;
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }

        return freq.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("rat", "car"));       // false
    }
}

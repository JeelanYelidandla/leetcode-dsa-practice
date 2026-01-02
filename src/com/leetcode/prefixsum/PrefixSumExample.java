package com.leetcode.prefixsum;

public class PrefixSumExample {
/*
✅ Correct Definition of Prefix Sum
👉 A Prefix Sum Array is defined as:
Each element at index i stores the sum of all elements from the start up to index i.
prefix[i] = array[0] + array[1] + ... + array[i]

🔹 Explanation:

| Index | array[i] | prefix[i] (sum of all previous) |
| ----- | -------- | ------------------------------- |
| 0     | 5        | 5                               |
| 1     | 10       | 5 + 10 = 15                     |
| 2     | 15       | 15 + 15 = 30                    |
| 3     | 20       | 30 + 20 = 50                    |
| 4     | 25       | 50 + 25 = 75                    |

✅ Prefix Sum — Meaning in Simple Words

Each element in the new array = (previous prefix sum) + (current element).

So it keeps adding the current element to the running total of all previous ones.

🔹 Example

Let’s say:

array = [5, 10, 15, 20, 25]


We’ll build a prefix sum array step-by-step:

| Index (i) | array[i] | prefix[i] = prefix[i-1] + array[i] | prefix array        |
| --------- | -------- | ---------------------------------- | ------------------- |
| 0         | 5        | 5                                  | [5]                 |
| 1         | 10       | 5 + 10 = 15                        | [5, 15]             |
| 2         | 15       | 15 + 15 = 30                       | [5, 15, 30]         |
| 3         | 20       | 30 + 20 = 50                       | [5, 15, 30, 50]     |
| 4         | 25       | 50 + 25 = 75                       | [5, 15, 30, 50, 75] |

🔹 Key Rule
    prefix[i] = prefix[i - 1] + array[i]

    with base case:
    prefix[0] = array[0]

    So you’re absolutely right when you said:
    “New array previous element + current element count till end of array”

That’s the exact intuition ✅ —
    you accumulate the sum of all previous elements up to the current index.

🔹 So Conceptually:
    If original array = [a₀, a₁, a₂, a₃, a₄]
    then prefix sum array = [a₀, a₀+a₁, a₀+a₁+a₂, a₀+a₁+a₂+a₃, a₀+a₁+a₂+a₃+a₄]

    create prefix array with same input array size.
    take array[0] index as prefix array first element: prefix[0] = array[0];
    for loop has to start from index i = 1;
 */
    private static void prefixSum(int[] array) {
        int[] prefix = new int[array.length];
        prefix[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }

        for (int num : prefix) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 25};
        prefixSum(array);
    }
}

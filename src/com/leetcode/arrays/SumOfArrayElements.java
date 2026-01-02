package com.leetcode.arrays;

import java.io.IO;

public class SumOfArrayElements {

    /*
✅ Final Answer
    Time Complexity: O(n)
    Space Complexity: O(1)

    🧩 1. When we compute a sum, what should be the initial value?

➡️ The default starting value for sum is always 0.

Because sum is an accumulative identity operation — that means:
sum = a₁ + a₂ + a₃ + ... + aₙ

sum = 0 + a₁ + a₂ + a₃ ...

✅ It doesn’t change the result — 0 is the neutral element for addition.
🧮 2. When do we use Integer.MIN_VALUE or Integer.MAX_VALUE?

Those are sentinel values, used in different kinds of problems:
| Use Case            | Initial Value       | Reason                                           |
| ------------------- | ------------------- | ------------------------------------------------ |
| **Finding maximum** | `Integer.MIN_VALUE` | So that any real element will be larger than it  |
| **Finding minimum** | `Integer.MAX_VALUE` | So that any real element will be smaller than it |
| **Finding sum**     | `0`                 | Because sum is additive, 0 is neutral            |

✅ Example Summary:
| Problem Type    | Initial Value       | Why                                  |
| --------------- | ------------------- | ------------------------------------ |
| Sum of elements | `0`                 | Identity element for addition        |
| Max element     | `Integer.MIN_VALUE` | To ensure any element can replace it |
| Min element     | `Integer.MAX_VALUE` | To ensure any element can replace it |

     */
    public static int getSumOfArrayElements(int[] array){
        int sum = 0;
        for(int i =0 ; i< array.length; i++){
            sum = array[i]+sum;
        }
        return sum;
    }
    static void main() {
        IO.println(SumOfArrayElements.getSumOfArrayElements(new int[]{10,20,30}));
    }
}

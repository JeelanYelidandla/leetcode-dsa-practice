package com.leetcode.recursion;

import java.io.IO;

public class Factorial {

/*
    💯 Excellent, Jeelan — this is exactly the kind of higher-order thinking that separates someone who “uses recursion” from someone who truly analyzes and designs it. 👏

You’re right — the time and space complexity of a recursive algorithm completely depends on how the input reduces per recursive call (e.g., n-1 vs n/10 vs n/2, etc.).

Let’s summarize everything in one clean comparison table 👇

🧠 Recursion Time & Space Complexity Patterns

| **Pattern Type**                     | **Recursive Relation**    | **Input Reduction per Call**                   | **Number of Calls** | **Time Complexity** | **Space Complexity (Stack Depth)** | **Typical Example**                                                             |
| ------------------------------------ | ------------------------- | ---------------------------------------------- | ------------------- | ------------------- | ---------------------------------- | ------------------------------------------------------------------------------- |
| **Linear Decrement (–1)**            | `T(n) = T(n - 1) + O(1)`  | Decreases by 1                                 | n                   | **O(n)**            | **O(n)**                           | Sum of N numbers, Factorial, Fibonacci (without memoization, exponential calls) |
| **Logarithmic (÷2)**                 | `T(n) = T(n / 2) + O(1)`  | Divides input by 2                             | log₂n               | **O(log n)**        | **O(log n)**                       | Binary Search, Power Calculation (`getPower(base, exp)`)                        |
| **Digit Division (÷10)**             | `T(n) = T(n / 10) + O(1)` | Removes one digit                              | log₁₀n              | **O(log n)**        | **O(log n)**                       | Count digits, Reverse number, Sum of digits                                     |
| **Constant (No Recursion)**          | `T(n) = O(1)`             | —                                              | 1                   | **O(1)**            | **O(1)**                           | Base case or simple return                                                      |
| **Two Recursive Calls (Branching)**  | `T(n) = 2T(n - 1) + O(1)` | Each call spawns 2 more                        | ~2ⁿ calls           | **O(2ⁿ)**           | **O(n)**                           | Fibonacci, Tower of Hanoi                                                       |
| **Multiple Branches (k calls)**      | `T(n) = kT(n - 1) + O(1)` | Branch factor = k                              | kⁿ                  | **O(kⁿ)**           | **O(n)**                           | Generating subsets, permutations                                                |
| **Divide & Conquer (Split in Half)** | `T(n) = 2T(n/2) + O(n)`   | Input split equally                            | log₂n levels        | **O(n log n)**      | **O(log n)**                       | Merge Sort, Quick Sort                                                          |
| **Tail Recursion (n-1)**             | `T(n) = T(n - 1) + O(1)`  | Same as linear                                 | n                   | **O(n)**            | **O(1)** (after optimization)      | Tail-recursive factorial or sum                                                 |
| **String Reduction (substring)**     | `T(n) = T(n - 1) + O(n)`  | Reduces by 1 char, copies new string each time | n                   | **O(n²)**           | **O(n)**                           | Reverse string with substring()                                                 |
| **Matrix Recursion (2D division)**   | `T(n) = 4T(n/2) + O(1)`   | Divide both dimensions by 2                    | log₂n levels        | **O(n²)**           | **O(log n)**                       | Strassen’s Matrix Multiplication                                                |


🔍 How to Read This Table

| Concept                      | Meaning                                                             |
| ---------------------------- | ------------------------------------------------------------------- |
| **T(n)**                     | Time for input size n                                               |
| **Input Reduction per Call** | How much smaller the problem becomes each call                      |
| **Number of Calls**          | How many total recursive invocations happen before base case        |
| **Stack Depth**              | Maximum number of active recursive calls at once (space complexity) |


🧩 Pattern Comparison Examples
| Function Type                  | Recurrence                    | Time     | Space    | Why                                     |
| ------------------------------ | ----------------------------- | -------- | -------- | --------------------------------------- |
| **Sum of N numbers**           | T(n) = T(n-1) + O(1)          | O(n)     | O(n)     | Linear recursion                        |
| **Sum of Digits**              | T(n) = T(n/10) + O(1)         | O(log n) | O(log n) | Each call removes one digit             |
| **Binary Search**              | T(n) = T(n/2) + O(1)          | O(log n) | O(log n) | Divide array by 2 each time             |
| **Power Function (2^n)**       | T(n) = T(n/2) + O(1)          | O(log n) | O(log n) | Divide exponent by 2                    |
| **Fibonacci (recursive)**      | T(n) = T(n-1) + T(n-2) + O(1) | O(2ⁿ)    | O(n)     | Two recursive calls per step            |
| **Reverse String (substring)** | T(n) = T(n-1) + O(n)          | O(n²)    | O(n)     | Substring() is O(n) per call            |
| **Tail Recursive Sum**         | T(n) = T(n-1) + O(1)          | O(n)     | O(1)     | Stack reused via tail call optimization |

🧠 Key Takeaways

n-1 pattern → Linear recursion → O(n)
(one call per step)

n/2 pattern → Logarithmic recursion → O(log n)
(divide problem in half)

n/10 pattern → Digit-based recursion → O(log₁₀n)
(one call per digit)

Substring or repeated string manipulation → O(n²)
(since new string copy each level)

Branching recursion → exponential
(each frame creates multiple recursive calls)

Tail recursion → constant space (if optimized)

💬 Interview Tip

When asked recursion complexity:

If input shrinks linearly (n → n-1): → O(n)

If input halves (n → n/2): → O(log n)

If digits shrink (n → n/10): → O(log n)

If two or more recursive calls per frame: → O(2ⁿ) or worse

If each call processes entire input (like substring): → O(n²)

✅ In summary:

The rate of input reduction and the number of recursive branches define your recursion’s time & space
complexity.

Would you like me to add one more column showing a mental model / visualization tip for each pattern
(like "linear stair", "divide tree", "digit chain") — that helps you instantly identify pattern type during interviews?
     */
    public static int getFactoria(int number){
        if(number==0){
            return 1;
        }else{
            return number * getFactoria(number-1);
        }
    }
    static void main() {
        IO.println(Factorial.getFactoria(5));
    }
}

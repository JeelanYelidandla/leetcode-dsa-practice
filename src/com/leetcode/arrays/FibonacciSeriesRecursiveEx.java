package com.leetcode.arrays;

public class FibonacciSeriesRecursiveEx {
    /*
This program generates the Fibonacci series using recursion.
f(n) = f(n-1) + f(n-2) formula is used to calculate the Fibonacci number at position n.
The base cases are f(0) = 0 and f(1) = 1
🎯 Goal

Find fib(5).

Mathematically:
fib(5) = fib(4) + fib(3)
fib(4) = fib(3) + fib(2)
fib(3) = fib(2) + fib(1)
fib(2) = fib(1) + fib(0)


🧩 Step 1: Recursion Build-up (Stack Tree Creation)

Each call spawns 2 new calls (until it hits base case).
This creates a recursion tree, not a straight stack like n-1 problems.

Tree structure for fibonacciRec(5):
                              fib(5)
                      /                   \
                fib(4)                     fib(3)
             /        \                  /        \
        fib(3)       fib(2)          fib(2)       fib(1)
       /     \       /    \          /    \
  fib(2)    fib(1) fib(1) fib(0)  fib(1) fib(0)
  /   \
fib(1) fib(0)


🪜 Step 2: Build-up Phase (Tree Expansion)

Let’s trace the build of the leftmost path (depth-first):
| Frame | Function Call | State                       | Comment               |
| ----- | ------------- | --------------------------- | --------------------- |
| F1    | fib(5)        | waiting for fib(4) + fib(3) | root call             |
| F2    | fib(4)        | waiting for fib(3) + fib(2) | left branch of fib(5) |
| F3    | fib(3)        | waiting for fib(2) + fib(1) | left branch of fib(4) |
| F4    | fib(2)        | waiting for fib(1) + fib(0) | left branch of fib(3) |
| F5    | fib(1)        | base → returns 1            | deepest call          |
| F6    | fib(0)        | base → returns 0            |                       |

At this point, recursion starts to unwind upward from fib(2).
🔁 Step 3: Unwind Phase (Returning Values Up the Tree)

Now we calculate bottom-up:
| Returning From | Expression    | Computation | Return Value |
| -------------- | ------------- | ----------- | ------------ |
| fib(1)         | base          | —           | 1            |
| fib(0)         | base          | —           | 0            |
| fib(2)         | fib(1)+fib(0) | 1+0         | **1**        |
| fib(3)         | fib(2)+fib(1) | 1+1         | **2**        |
| fib(4)         | fib(3)+fib(2) | 2+1         | **3**        |
| fib(5)         | fib(4)+fib(3) | 3+2         | **5**        |


✅ Final Answer → 5
📈 Step 4: Full Tree with Return Values

Let’s attach the computed results to the tree:

                             fib(5)=5
                      /                     \
               fib(4)=3                     fib(3)=2
             /        \                    /        \
        fib(3)=2     fib(2)=1         fib(2)=1      fib(1)=1
       /     \       /    \           /    \
  fib(2)=1  fib(1)=1 fib(1)=1 fib(0)=0  fib(1)=1 fib(0)=0
  /   \
fib(1)=1 fib(0)=0

✅ You can now see that many subproblems repeat — like fib(3) and fib(2) being recalculated multiple times.
That’s why Fibonacci recursion is exponential in time.

🧮 Step 5: Time and Space Complexity
| Complexity           | Explanation                                                                                 |
| -------------------- | ------------------------------------------------------------------------------------------- |
| **Time Complexity**  | **O(2ⁿ)** → Each call spawns 2 new calls. The recursion tree doubles roughly at each level. |
| **Space Complexity** | **O(n)** → Max stack depth = height of recursion tree = n (leftmost branch).                |

⚙️ Step 6: Execution Order Summary (Call Stack Timeline)
Build-up Phase (left-first, depth-first):

fib(5)
 → fib(4)
   → fib(3)
     → fib(2)
       → fib(1)
       → fib(0)


fib(1) → returns 1
fib(0) → returns 0
fib(2) → returns 1
fib(3) → returns 2
fib(4) → returns 3
fib(5) → returns 5

Then other right-side branches (fib(3), fib(2), etc.) follow similarly


💬 Step 7: Interview-Ready Explanation

If asked in an interview, you can confidently say:

“In Fibonacci recursion, each call splits into two — fib(n-1) and fib(n-2).
The recursion tree expands until base cases fib(0) and fib(1) return.
During unwind, results from both subcalls are added to form the parent result.

The recursion tree has height n, so space = O(n).
But since each node spawns 2 children, the total number of calls grows exponentially — O(2ⁿ) time complexity.”


| Concept                   | Value                                             |
| ------------------------- | ------------------------------------------------- |
| **Base Cases**            | fib(0)=0, fib(1)=1                                |
| **Recursive Relation**    | fib(n) = fib(n-1) + fib(n-2)                      |
| **Build-up**              | Tree expands left and right (2 branches per node) |
| **Unwind**                | Add results of both recursive branches            |
| **Final Output (fib(5))** | 5                                                 |
| **Time Complexity**       | O(2ⁿ)                                             |
| **Space Complexity**      | O(n)                                              |
| **Improvement Tip**       | Use memoization → O(n) time, O(n) space           |


fib(5)
 ├── fib(4)
 │    ├── fib(3)
 │    │    ├── fib(2)
 │    │    │    ├── fib(1) → returns 1
 │    │    │    └── fib(0) → returns 0
 │    │    │         ↳ fib(2) returns 1 + 0 = 1
 │    │    ├── fib(1) → returns 1
 │    │    │    ↳ fib(3) returns 1 + 1 = 2
 │    ├── fib(2)
 │    │    ├── fib(1) → returns 1
 │    │    └── fib(0) → returns 0
 │    │         ↳ fib(2) returns 1 + 0 = 1
 │    │    ↳ fib(4) returns 2 + 1 = 3
 └── fib(3)
      ├── fib(2)
      │    ├── fib(1) → returns 1
      │    └── fib(0) → returns 0
      │         ↳ fib(2) returns 1 + 0 = 1
      ├── fib(1) → returns 1
      │    ↳ fib(3) returns 1 + 1 = 2
 ↳ fib(5) returns 3 + 2 = 5


    */
    public static int fibonacciRec(int n) {
        if (n <= 1) {
            return n; // Base cases: fib(0) = 0, fib(1) = 1
        }
        //frame -1 :  4 -1 = 3 and 4-2 = 2
        //frame - 2 : 3-1 = 2 and 3-2 = 1
        return fibonacciRec(n - 1) + fibonacciRec(n - 2); // Recursive call
    }

    public static void main(String[] args) {
        int count = 5; // Number of Fibonacci numbers to generate
//        for (int i = 0; i < count; i++) {
        System.out.print(fibonacciRec(count) + " ");
//        }
    }
}


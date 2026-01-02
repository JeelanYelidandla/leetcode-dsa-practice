package com.leetcode.recursion;

import java.io.IO;

public class SumOfDigits {

    /*
    🪜 Step-by-Step Execution (with n = 123)

    | Step | Function Call      | Condition | Expression to Evaluate                                       |
| ---- | ------------------ | --------- | ------------------------------------------------------------ |
| 1️⃣  | `sumOfDigits(123)` | not 0     | `(123 % 10) + sumOfDigits(123 / 10)` → `3 + sumOfDigits(12)` |
| 2️⃣  | `sumOfDigits(12)`  | not 0     | `(12 % 10) + sumOfDigits(12 / 10)` → `2 + sumOfDigits(1)`    |
| 3️⃣  | `sumOfDigits(1)`   | not 0     | `(1 % 10) + sumOfDigits(1 / 10)` → `1 + sumOfDigits(0)`      |
| 4️⃣  | `sumOfDigits(0)`   | base case | returns **0**                                                |


🔁 Step-by-Step Unwinding
Now, recursion starts returning upward — evaluating the pending additions.

| Returning From     | Expression            | Computation | Return Value |
| ------------------ | --------------------- | ----------- | ------------ |
| `sumOfDigits(0)`   | base → returns 0      | —           | **0**        |
| `sumOfDigits(1)`   | `1 + sumOfDigits(0)`  | `1 + 0`     | **1**        |
| `sumOfDigits(12)`  | `2 + sumOfDigits(1)`  | `2 + 1`     | **3**        |
| `sumOfDigits(123)` | `3 + sumOfDigits(12)` | `3 + 3`     | **6**        |


🧩 Build-up + Unwind Visualization
Build-up Phase (function calls)

sumOfDigits(123)
 └─ sumOfDigits(12)
      └─ sumOfDigits(1)
           └─ sumOfDigits(0)

Unwind Phase (returns)
sumOfDigits(0) → 0
sumOfDigits(1) → 1 + 0 = 1
sumOfDigits(12) → 2 + 1 = 3
sumOfDigits(123) → 3 + 3 = 6

🔍 Execution Order Insight
During build-up (right side first):

Keeps calling sumOfDigits(n/10) until base case.

During unwind:

Adds back the left-hand side (n % 10) one by one.

So, if you visualize mathematically:
sumOfDigits(123)
= (3) + sumOfDigits(12)
= (3) + [(2) + sumOfDigits(1)]
= (3) + [(2) + [(1) + sumOfDigits(0)]]
= (3) + [(2) + [(1) + 0]]
= (3) + [(2) + 1]
= (3) + 3
= 6

⚙️ Complexity Analysis
| Type                | Complexity | Reason                                            |
| ------------------- | ---------- | ------------------------------------------------- |
| ⏱️ Time Complexity  | **O(d)**   | d = number of digits; one call per digit          |
| 💾 Space Complexity | **O(d)**   | d stack frames (each call stored until base case) |

✅ Final Summary
| Concept                  | Description                                   |
| ------------------------ | --------------------------------------------- |
| **Base case**            | When n = 0 → return 0                         |
| **Recursive call**       | sumOfDigits(n/10)                             |
| **Constant part**        | (n % 10) added after recursion returns        |
| **Execution order**      | Right (recursive call) first → Left (+) later |
| **Final output for 123** | 6                                             |
| **Time Complexity**      | O(d)                                          |
| **Space Complexity**     | O(d)                                          |

     */
    private static int sumOfDigits(int n){
        if (n == 0)
            return 0;
        else
            return (n%10) + sumOfDigits(n/10);
    }

    static void main() {
        int  n = 123;
        IO.println(SumOfDigits.sumOfDigits(n));
    }
}

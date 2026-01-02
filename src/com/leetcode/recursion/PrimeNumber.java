package com.leetcode.recursion;

import java.io.IO;

public class PrimeNumber {

/*
    isPrime(7, 3)

Step-by-step:
| Step | Function Call   | Condition Checked | Result / Action       |
| ---- | --------------- | ----------------- | --------------------- |
| 1️⃣  | `isPrime(7, 3)` | `7 % 3 != 0`      | calls `isPrime(7, 2)` |
| 2️⃣  | `isPrime(7, 2)` | `7 % 2 != 0`      | calls `isPrime(7, 1)` |
| 3️⃣  | `isPrime(7, 1)` | `i == 1` ✅        | returns **true**      |

🧱 Stack Trace Table (for n = 7, i = 3)

| Returning From  | Expression / Condition                    | Computation | Return Value |
| --------------- | ----------------------------------------- | ----------- | ------------ |
| `isPrime(7, 1)` | base case `i == 1`                        | —           | **true**     |
| `isPrime(7, 2)` | `7 % 2 != 0` → calls inner → returns true | **true**    |              |
| `isPrime(7, 3)` | `7 % 3 != 0` → calls inner → returns true | **true**    |              |

*/
    private static boolean isPrime(int n, int i){
        if (n <= 1)
            return false;
        if (i == 1)
            return true;
        if (n % i == 0)
            return false;
        return isPrime(n, i - 1);
    }

    static void main() {
       int  n = 6;
        IO.println(PrimeNumber.isPrime(n,n/2));
    }
}

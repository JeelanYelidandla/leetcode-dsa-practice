package com.leetcode.recursion;

import java.io.IO;

public class MultiplicationInRecursion {


    /*
| Returning From            | Expression                    | Computation | Return Value |
| ------------------------- | ----------------------------- | ----------- | ------------ |
| `getMultiplication(3, 0)` | base case                     | —           | **0**        |
| `getMultiplication(3, 1)` | `3 + getMultiplication(3, 0)` | `3 + 0`     | **3**        |
| `getMultiplication(3, 2)` | `3 + getMultiplication(3, 1)` | `3 + 3`     | **6**        |
| `getMultiplication(2, 3)` | swapped result of above       | returns 6   | **6**        |

getMultiplication(3,0) → 0
getMultiplication(3,1) → 3 + 0 = 3
getMultiplication(3,2) → 3 + 3 = 6
getMultiplication(2,3) → swapped → 6

| Type                 | Depends on | Why                                                                |
| -------------------- | ---------- | ------------------------------------------------------------------ |
| **Time Complexity**  | `b`        | One recursive call per value of `b` (reducing each time)           |
| **Space Complexity** | `b`        | Stack depth equals number of recursive calls made before base case |
| **Constant**         | `a`        | Doesn’t affect recursion depth                                     |


✅ Final Answer = 6
✅ Time Complexity = O(b)
✅ Space Complexity = O(b)



     */
    public static int getMultiplication(int a, int b){
        if(a<b)
            return getMultiplication(b,a);
        if(b!=0)
            return a+ getMultiplication(a, b-1);
        else
            return 0;
    }
    static void main() {
        IO.println( MultiplicationInRecursion.getMultiplication(2,3));
    }
}

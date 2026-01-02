package com.leetcode.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelfPrefixSum {

/*

| Line / Operation                    | Time Complexity | Space Complexity | Explanation                                                                  |
| ----------------------------------- | --------------- | ---------------- | ---------------------------------------------------------------------------- |
| `int[] ans = new int[nums.length];` | O(n)            | O(n)             | Allocating an array of size n (Java initializes with 0s)                     |
| `int prefix = 1;`                   | O(1)            | O(1)             | Scalar variable                                                              |
| First `for` loop (runs n times)     | O(n)            | O(1)             | `i` is scalar; each step does O(1) work (`ans[i]=prefix`, `prefix*=nums[i]`) |
| Inside loop `ans[i] = prefix`       | O(1)            | O(1)             | Writes to existing array slot                                                |
| Inside loop `prefix *= nums[i]`     | O(1)            | O(1)             | Simple multiplication and assignment                                         |
| `int suffix = 1;`                   | O(1)            | O(1)             | Scalar variable                                                              |
| Second `for` loop (runs n times)    | O(n)            | O(1)             | Each iteration is O(1) work (`ans[i]*=suffix`, `suffix*=nums[i]`)            |
| Inside loop `ans[i] *= suffix`      | O(1)            | O(1)             | Updates existing array slot                                                  |
| Inside loop `suffix *= nums[i]`     | O(1)            | O(1)             | Simple multiplication and assignment                                         |
| `return ans;`                       | O(1)            | O(1)             | Just returning reference                                                     |

🔑 Pattern

The core pattern here is:
We can’t use division, so we need prefix & suffix products.
Use two passes:
    Left-to-right → store prefix product so far.
    Right-to-left → multiply suffix product so far.
    That’s the conceptual pattern. If you understand this, you don’t need to memorize every line.

🚀 How to Remember (without rote memorization)
Instead of memorizing the whole loop code, train your brain like this:
👉 If problem says: “Product of array except self without division”
Think:
I need prefix + suffix multiplication.
That means two passes.
    First pass → left products.
    Second pass → right products.
    The loop code will then flow naturally when you implement.

Final Summary:

Time Complexity:
    Array allocation: O(n)
    Two loops: O(n) + O(n) = O(2n)
    Drop constant → O(n) ✅

Space Complexity:
    Extra array ans: O(n)
    Scalars (prefix, suffix, i): O(1)
    Total → O(n) ✅

 */
    public static int[] getProductOfArrayExceptSelf(int [] nums){
        int[] ans = new int[nums.length]; // Time O(1) and Space O(n)
        int prefix = 1; // O(1) time and space
        // 1) Left pass: ans[i] = product of all elements to the left
       for(int i =0; i< nums.length; i++){ // Time complexity O(n) space O(1) for int i
            ans[i] =  prefix;  //space complexity O(1) time O(1)
            prefix = prefix * nums[i]; //space complexity O(1) time O(1)
        }

       int suffix= 1; // O(1) time and space
        // 2) Right pass: multiply by product of all elements to the right
        for (int i = nums.length-1; i >= 0 ; i--) { // time complexity O(n) sapce o(1) for int i
            ans[i] = ans[i]*  suffix; //space complexity O(1) time O(1)
            suffix = suffix * nums[i]; //space complexity O(1) time O(1)
        }

        return ans; //time and space complexity O(1)
    }
    static void main() {
        int result [] =    getProductOfArrayExceptSelf(new int [] {1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }
}

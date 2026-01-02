package com.leetcode.time.space.complexity.problems;

public class BigOofNSolutions {
    /*
    1. ✅ If array is constant or fixed pattern (e.g. 1 to n)
You can reduce time to O(1) by using a math formula.
Example:
     */
    int sumFrom1ToN(int n) {
        return (n * (n + 1)) / 2;  // O(1)
    }

}

/*First time: O(n)
Next calls: O(1)

2. ✅ If array doesn't change and is reused often
You can cache the result after the first sum, saving time later.

3. ❌ You cannot reduce O(n) for unknown/unbounded arrays
int[] arr = {5, 3, 10, 1, 8, ...}; // unknown values
Then the only correct way is to visit all elements → O(n) is best possible.

*/
class CachedSum {
    private int[] arr;
    private Integer cachedSum = null;

    public CachedSum(int[] arr) {
        this.arr = arr;
    }

    public int getSum() {
        if (cachedSum == null) {
            cachedSum = 0;
            for (int num : arr) cachedSum += num;
        }
        return cachedSum;
    }
}

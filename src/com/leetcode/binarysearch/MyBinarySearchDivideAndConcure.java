package com.leetcode.binarysearch;

/*A binary search or half-interval search algorithm finds the position of a specified value (the input "key") within a sorted array. 
 * In each step, the algorithm compares the input key value with the key value of the middle element of the array. If the keys match, 
 * then a matching element has been found so its index, or position, is returned. Otherwise, if the sought key is less than the middle element's key, 
 * then the algorithm repeats its action on the sub-array to the left of the middle element or, if the input key is greater, on the sub-array to the right. 
 * If the remaining array to be searched is reduced to zero, then the key cannot be found in the array and a special "Not found" indication is returned.

Every iteration eliminates half of the remaining possibilities. This makes binary searches very efficient - even for large collections.

Binary search requires a sorted collection. Also, binary searching can only be applied to a collection that allows random access (indexing).

Worst case performance: O(log n)

Best case performance: O(1)

* /**
     *
     * O(1)       → Fastest (constant)
     * O(log n)   → Very fast
     * O(√n)      → Fast (rare but better than linear)
     * O(n)       → Acceptable for large inputs
     * O(n log n) → Efficient for sorting
     * O(n²)      → OK for small inputs only
     * O(n³)      → Slow, avoid for large n
     * O(2ⁿ)      → Very slow (bad for n > 20)
     * O(n!)      → Worst case (almost always intractable)
     *
     *
     * | Big-O          | Name              | Example Usage / Notes                            |
     * | -------------- | ----------------- | ------------------------------------------------ |
     * | **O(1)**       | Constant Time     | Array access `arr[0]`, hashmap lookup            |
     * | **O(log n)**   | Logarithmic Time  | Binary search, balanced tree search              |
     * | **O(√n)**      | Square Root Time  | Some primality checks, certain grid problems     |
     * | **O(n)**       | Linear Time       | Single loop, scanning an array                   |
     * | **O(n log n)** | Linearithmic Time | Merge Sort, QuickSort average case               |
     * | **O(n²)**      | Quadratic Time    | Nested loops (e.g., bubble sort, matrix compare) |
     * | **O(n³)**      | Cubic Time        | Triple nested loops                              |
     * | **O(2ⁿ)**      | Exponential Time  | Brute-force recursion, some DP problems          |
     * | **O(n!)**      | Factorial Time    | Permutations, traveling salesman, brute-force    |
     *
     * @param array
     * @param num
     * @return valid number if its available otherwise return -1
     *
    Exactly 😄 — you’ve nailed the shortcut way to remember it without doing the algebra dance.
    Here’s that intuition written cleanly:
    Question: How many times can we divide n by 2 until we reach 1?
    Answer: That count =𝑘==log base 2 n
    where 𝑘 is the number of divisions needed to reduce n to 1. n is the size of the array.
    Example:
    n=16
    16 → 8 → 4 → 2 → 1
    That’s 4 divisions, so 𝑘=4

    Check with formula: log base 2 of 16 = 4

    | **n**     | **log₂(n)** | **# of Halvings (k)** |
    | --------- | ----------- | --------------------- |
    | 1         | 0           | 0 steps (already 1)   |
    | 2         | 1           | 1 step                |
    | 4         | 2           | 2 steps               |
    | 8         | 3           | 3 steps               |
    | 16        | 4           | 4 steps               |
    | 32        | 5           | 5 steps               |
    | 64        | 6           | 6 steps               |
    | 128       | 7           | 7 steps               |
    | 256       | 8           | 8 steps               |
    | 512       | 9           | 9 steps               |
    | 1,024     | 10          | 10 steps              |
    | 1,048,576 | 20          | 20 steps              |
    | 1 billion | \~30        | \~30 steps            |

    If they give n = 1,000,000, just remember:
    2¹⁰ ≈ 1,000 → so 2²⁰ ≈ 1,000,000 → about 20 steps.
    For huge arrays, you can impress them by saying
    “Even with 1 billion elements, binary search takes ~30 steps.”

     * create two left=0 and right= length-1 variable
     * iterate array using while loop left<= right
     * find mid using mid  = left + (right-left)/2
     * check    if array[mid] == num)
     *              return mid
     *          else if( array[mid]< num)
     *               left =  mid+1
 *               check if (array[mid] > num )
     *                  right = mid -1;
     *
*

*/
public class MyBinarySearchDivideAndConcure {
 
    public int binarySearch(int[] inputArr, int searchValue) {
         
        int start = 0;
        int end = inputArr.length;
        while (start < end) {
            // Better mid calculation to prevent potential integer overflow
            // int mid = start + (end - start) / 2;
            int mid = (start + end) / 2;
            if (searchValue == inputArr[mid]) {
                return mid;
            }
            if (searchValue < inputArr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
  
    public static void main(String[] args) {
         
    	MyBinarySearchDivideAndConcure mbs = new MyBinarySearchDivideAndConcure();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: "+mbs.binarySearch(arr, 14));
        int[] arr1 = {6,34,78,123,432,900};
        System.out.println("Key 432's position: "+mbs.binarySearch(arr1, 432));
    }
}
	
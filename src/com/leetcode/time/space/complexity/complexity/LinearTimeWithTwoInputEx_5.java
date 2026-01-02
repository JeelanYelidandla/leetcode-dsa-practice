package com.leetcode.time.space.complexity.complexity;

public class LinearTimeWithTwoInputEx_5 {

    /*  // Time: O(n + m) - goes through both arrays
        // Space: O(n + m) - new array stores all elements
        This code demonstrates linear time complexity with two input arrays.
        The method `mergeArrays(int[] a, int[] b)` merges two arrays into one.
        The time complexity is O(n + m), where n is the length of the first array and m is the length of the second array.
        The space complexity is O(n + m) as well, since we are creating a new array to hold the merged result.
        The method uses `System.arraycopy` to copy elements from both input arrays into a new array.
        The time taken to execute this code increases linearly with the size of the input arrays.

     */
    private static int[] mergeArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static void main(String[] args) {

    }
}

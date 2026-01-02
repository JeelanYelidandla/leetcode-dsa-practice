package com.leetcode.arrays;

import java.io.IO;

public class FindMinMaxSinglePass {

    public static void getMinMaxUsingSingleLoop(int[] array) {
        if (array == null || array.length == 0) {
            IO.println("Array is empty");
            return;
        }

        int min, max;
        int i;

        // Initialize
        if (array.length % 2 == 0) {
            if (array[0] < array[1]) {
                min = array[0];
                max = array[1];
            } else {
                min = array[1];
                max = array[0];
            }
            i = 2; // start from index 2
        } else {
            min = max = array[0];
            i = 1;
        }

        // Compare in pairs
        while (i < array.length - 1) {
            int localMin, localMax;
            if (array[i] < array[i + 1]) {
                localMin = array[i];
                localMax = array[i + 1];
            } else {
                localMin = array[i + 1];
                localMax = array[i];
            }

            if (localMin < min) min = localMin;
            if (localMax > max) max = localMax;

            i += 2;
        }

        IO.println("Minimum: " + min);
        IO.println("Maximum: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 5, 40, 30};
        getMinMaxUsingSingleLoop(arr);
    }
}

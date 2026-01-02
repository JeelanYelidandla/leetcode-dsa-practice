package com.leetcode.slidingwindow;

import java.io.IO;

public class MinimumSizeSubarraySum {

    public static int minimumSizeSubarraySum(int array[],int target){
        int left = 0;

        int minLength = Integer.MAX_VALUE; // <-- better name
        int sum = 0;
//        IO.println(array.length);
        for (int right = 0; right < array.length; right++) {
            sum = sum+array[right];
            while(sum >= target){
//                minSubArraySum = Math.min(sum, right-left+1);
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - array[left];
                left++;
            }

        }
        return  minLength== Integer.MAX_VALUE ? 0 : minLength;
    }
    static void main() {
        IO.println(minimumSizeSubarraySum(new int[]{2, 3, 1, 2, 4, 3},7));
    }
}

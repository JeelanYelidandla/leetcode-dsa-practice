package com.leetcode.prefixsum;

public class RangeSumQuery {
    private static int[] buildPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }

    private static int rangeSum(int[] prefix, int left, int right) {
        if (left == 0)
            return prefix[right];
        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {5, 10, 15, 20, 25};
        int[] prefix = buildPrefixSum(nums);

        System.out.println("Sum(1,3) = " + rangeSum(prefix, 1, 3)); // 45
        System.out.println("Sum(0,4) = " + rangeSum(prefix, 0, 4)); // 75
        System.out.println("Sum(2,4) = " + rangeSum(prefix, 2, 4)); // 60
    }
}

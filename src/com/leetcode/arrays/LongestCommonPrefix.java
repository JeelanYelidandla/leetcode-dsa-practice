package com.leetcode.arrays;

public class LongestCommonPrefix {

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxPrefix = 0;

        for (int num1 : arr1) {
            String s1 = String.valueOf(num1);

            for (int num2 : arr2) {
                String s2 = String.valueOf(num2);

                int count = 0;
                for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                    if (s1.charAt(i) == s2.charAt(i)) {
                        count++;
                    } else {
                        break;
                    }
                }

                maxPrefix = Math.max(maxPrefix, count);
            }
        }

        return maxPrefix;
    }

    public static void main(String[] args) {
        int[] arr1 = {123, 456, 789};
        int[] arr2 = {1299, 459, 785};

        System.out.println("Longest Common Prefix Length: " + longestCommonPrefix(arr1, arr2));
    }
}

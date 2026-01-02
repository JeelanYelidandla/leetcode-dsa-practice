package com.leetcode.arrays;

public class MoveZeroAtTheEndOfArray {

    public static void moveZeroes(int[] nums){
        
       int index = 0;
       for(int num : nums) {
           if (num != 0) {
                nums[index++] = num; // Place non-zero elements at the front
           }
       }

       while (index < nums.length){
           nums[index++] = 0; // Fill the rest of the array with zeros
       }
    }

    public static void moveZeroesUsingTemp(int[] nums) {
//        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[i + 1]; // Shift the next element to the current position
                nums[i + 1] = temp; // Place the zero at the end
                i--; // Decrement i to check the new element at this position
            }

        }
    }
    static void main() {
        int nums[] = {0, 1, 0, 3, 12};
        System.out.println("Before moving zeroes:");
        moveZeroes(nums);
        System.out.println("After moving zeroes:");
        for(int num : nums) {
            System.out.print(num + " ");
        }

    }

}

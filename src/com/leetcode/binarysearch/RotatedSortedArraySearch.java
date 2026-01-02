package com.leetcode.binarysearch;



/*
Explanation:

Initialization:

    low is set to the start of the array (index 0).
    high is set to the end of the array (index nums.length - 1).

Binary Search Loop:

        The loop continues as long as low is less than or equal to high.
        mid is calculated as the middle index. Using low + (high - low) / 2 helps prevent potential integer overflow that might occur with (low + high) / 2 if low and high are very large.


Target Check:

If nums[mid] is equal to the target, we've found the element, and its index mid is returned.


Determining the Sorted Half:

If nums[low] <= nums[mid]: This condition means the subarray from nums[low] to nums[mid] is sorted in ascending order.
    We then check if the target lies within this sorted range (target >= nums[low] && target < nums[mid]).
    If it does, we narrow our search to the left half by setting high = mid - 1.
    Otherwise, the target must be in the right (unsorted or differently sorted) half, so we set low = mid + 1.

Else (nums[low] > nums[mid]): This implies that the rotation point is somewhere in the left half, and thus the subarray from nums[mid] to nums[high] must be sorted in ascending order.
We then check if the target lies within this sorted right range (target > nums[mid] && target <= nums[high]).
If it does, we narrow our search to the right half by setting low = mid + 1.
Otherwise, the target must be in the left half, so we set high = mid - 1.


Target Not Found:

    If the loop finishes without finding the target (i.e., low becomes greater than high), it means the target is not present in the array. In this case, -1 is returned.



How it works with your examples:
Input: nums = [3,4,5,6,1,2], target = 1

low=0, high=5, mid=2 (val=5). nums[0] <= nums[2] (3<=5) is true. target < nums[0] (1<3) is true. low = mid + 1 = 3.
low=3, high=5, mid=4 (val=1). nums[mid] == target. Return 4. ✅

Input: nums = [4,5,6,1,2,3], target = 1
low=0, high=5, mid=2 (val=6). nums[0] <= nums[2] (4<=6) is true. target < nums[0] (1<4) is true. low = mid + 1 = 3.
low=3, high=5, mid=4 (val=2). nums[3] <= nums[4] (1<=2) is true. target >= nums[3] (1>=1) and target < nums[4] (1<2) is true. high = mid - 1 = 3.
low=3, high=3, mid=3 (val=1). nums[mid] == target. Return 3. ✅

Input: nums = [6,1,2,3,4,5], target = 1
low=0, high=5, mid=2 (val=2). nums[0] <= nums[2] (6<=2) is false. Right half is sorted. target > nums[2] (1>2) is false. high = mid - 1 = 1.
low=0, high=1, mid=0 (val=6). nums[0] <= nums[0] (6<=6) is true. target < nums[0] (1<6) is true. low = mid + 1 = 1.
low=1, high=1, mid=1 (val=1). nums[mid] == target. Return 1. ✅
 */
public class RotatedSortedArraySearch {

    //int[] nums1 = {3, 4, 5, 6, 1, 2};
    public static int searchInRotatedSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                //Target is in the left sorted half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    // Target is in the right half
                    left = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Target is in the right sorted half
                if (nums[mid] < target && target <= nums[right-1]) {
                    left = mid + 1;
                } else {
                    // Target is in the left half
                    right = mid;
                }
            }
        }
        
        return -1; // Target not found
    }
    
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 6, 1, 2};
//        System.out.println(searchInRotatedSortedArray(nums1, 1)); // Output: 4


        // Test cases
        int[] nums3 = {6, 1, 2, 3, 4, 5};
        System.out.println(searchInRotatedSortedArray(nums3, 1)); // Output: 1


        int[] nums2 = {4, 5, 6, 1, 2, 3};
//        System.out.println(searchInRotatedSortedArray(nums2, 1)); // Output: 3
        

    }
}
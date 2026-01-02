package com.leetcode.arrays;

import java.util.HashSet;

/*
Arrays & Hashing (8 Questions)

Two Sum
Contains Duplicate
Valid Anagram
Group Anagrams
Top K Frequent Elements
Product of Array Except Self
Intersection of Two Arrays
Longest Consecutive Sequence
 */
public class ContainsDuplicates {
    /*
        Time Complexity: O(n)
        Space Complexity: O(n) worse case.

     */
    public static boolean isDuplicate(int intArray[]){
        if(intArray == null  || intArray.length==0){
            throw new IllegalArgumentException("Array Should Not Be Empty "+ intArray);
        }
        var set = new HashSet<Integer>(); // time complexity O(1)
        for (int num : intArray){ // time complexity: O(n)
            if(set.contains(num)) // time complexity O(1)
                return true; //time complexity O(1)
            set.add(num); // Space complexity O(n) worse case.
        }
       return false; //time complexity O(1)
    }
    static void main() {
//        System.out.println(ContainsDuplicates.isDuplicate(null));
        System.out.println(ContainsDuplicates.isDuplicate(new int []{10,10,20}));
    }
}

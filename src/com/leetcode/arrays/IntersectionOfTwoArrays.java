package com.leetcode.arrays;

import java.util.*;

/*
Intersection of Two Arrays
 */
public class IntersectionOfTwoArrays {

 /*
Time Complexity = O(n + m)
  - O(n) to insert array1 into HashSet
  - O(m) to traverse array2 and check membership if(array1HashSet.contains(num))

Space Complexity: O(n)
  - HashSet stores array1 elements, worst case no duplicates → O(n)
  - Result List stores intersection elements, worst case array1 and array2 same → O(n)
  - Total space → O(n + k) → worst case O(2n) → remove constants → O(n)
  - Arbitrary loop variables → O(1)
*/

    public static List<Integer> getDuplicateElementFromTwoArrays(int array1[] , int array2[]){
        var array1HashSet = new HashSet<Integer>(); // O(n) time and O(n) space complexity worese case no duplicates in array
        var resultList = new ArrayList<Integer>();// O(1) time and space complexity
        for (int num: array1){// O(n) time and O(1)space complexity
            array1HashSet.add(num); // O(1) time and space complexity
        }

        for (int num: array2){ // O(m) time and O(1) space complexity
            if(array1HashSet.contains(num)){ // O(1) time complexity and O(1) space complexity
                resultList.add(num); //O(1) time complexity with amortize
            }
        }
        return  resultList;
    }

    static void main() {
         System.out.println(IntersectionOfTwoArrays.getDuplicateElementFromTwoArrays(new int [] {1,2,2,3}, new int [] {2,1,4}));
    }
}

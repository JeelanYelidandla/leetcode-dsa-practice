package com.leetcode.string;

import java.util.Arrays;

public class AnagramWithSortingEx {

    /*
    Overall Time complexity: O(n log n)
    Overall Space Complexity : O(n)

     */
    public static boolean isAnagram(String str1, String str2){
      if(str1.isEmpty() || str2.isEmpty())
          throw new IllegalArgumentException("Str1 or Str2 both should not empty");
      str1 =  str1.toLowerCase().replaceAll("^a-zA-Z",""); // time complexity O(n)
      str2 = str2.toLowerCase().replaceAll("^a-zA-Z","");// time complexity O(n)
      if(str1.length()!=str2.length())
          return false;
      var charArrayStr1 = str1.toCharArray(); // time and space complexity  O(n)
      var charArrayStr2 =str2.toCharArray();// time and space complexity O(n)
      Arrays.sort(charArrayStr1); //  time complexity O(n log n)
      Arrays.sort(charArrayStr2);// time complexity O(n log n)

      return Arrays.equals(charArrayStr1,charArrayStr2); // time complexity O(n) O(n) Space complexity
    }
    static void main() {
        System.out.println(AnagramWithSortingEx.isAnagram("abc", "cba"));
    }
}

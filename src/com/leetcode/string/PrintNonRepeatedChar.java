package com.leetcode.string;

import java.io.IO;
import java.util.LinkedHashMap;

public class  PrintNonRepeatedChar{
    /*
        * Find the first non-repeated character in a string.
        * time complexity O(n) and space complexity O(n)
     */
    public static void findNonRepeatedChar(String str) {
        var map = new LinkedHashMap<Character, Integer>(); // time complexity O(1) and Space complexity O(1)
        char[] charArray =   str.toCharArray(); // time complexity O(n) and space complexity O(n)
        if(str != null && !str.isEmpty()) { // time complexity O(1) and space complexity O(1)
             for (char c : charArray){ // time complexity O(n) and space complexity O(1)
                 map.put(c, map.getOrDefault(c,0)+1); // time complexity O(1) and space complexity O(1)
             }
        }

        IO.println(map.entrySet()
                .stream()
                .filter(x->x.getValue()==1)
                .map(x->x.getKey())
                .toList()
                .reversed()
                .get(0));


    }
    public static void main(String[] args) {
           findNonRepeatedChar("acbabd");
    }
}

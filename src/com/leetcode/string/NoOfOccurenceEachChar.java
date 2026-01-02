package com.leetcode.string;

import java.io.IO;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NoOfOccurenceEachChar {

    /*
     * Count the number of occurrences of each character in a string.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Map getNoOfOccurenceEachChar(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("String should not be null or empty");
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] charArray = name.toCharArray();
        for (Character c : charArray){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map;

    }
    static void main() {
       Map<Character,Integer> occurenceMap = NoOfOccurenceEachChar.getNoOfOccurenceEachChar("Jeelan");
        occurenceMap.forEach((key,value)-> IO.println( key +" " + value));
    }
}

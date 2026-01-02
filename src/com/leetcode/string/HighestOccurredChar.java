package com.leetcode.string;

import java.io.IO;
import java.util.LinkedHashMap;
import java.util.Map;

public class HighestOccurredChar {

    /*
     * Finds the highest occurred alphanumeric character in a given string.
     * Ignores special characters and spaces.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static char getHigestOccurredChar(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name should not be null or empty string");
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character character: name.toCharArray()){
            if(Character.isLetterOrDigit(character))
            map.put(character,map.getOrDefault(character,0)+1);
        }
        char ch = 0;
        int maxValue = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                ch = entry.getKey();
            }
        }
        return ch;
    }
    static void main() {
        IO.println(HighestOccurredChar.getHigestOccurredChar("Jeelannn"));


        /*char highest = "Jeelan".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();*/

    }
}

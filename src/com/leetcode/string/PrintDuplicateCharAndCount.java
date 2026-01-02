package com.leetcode.string;

import java.io.IO;
import java.util.*;
import java.util.stream.Collectors;

public class PrintDuplicateCharAndCount {


    /*
     * Print all duplicate characters and their count from the given string.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Map<Character,Integer> getDuplicateCharCount(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("String should not be null or empty");
        }
        Map<Character,Integer> duplicateCharAndCountMap = new LinkedHashMap<>();

        for (char character : name.toCharArray()) {
                duplicateCharAndCountMap.put(character,duplicateCharAndCountMap.getOrDefault(character,0)+1);

        }

        return duplicateCharAndCountMap;
    }
    static void main() {
        Map<Character,Integer> duplicateCharAndCountMap = getDuplicateCharCount("Programming");
        IO.println(duplicateCharAndCountMap);

       duplicateCharAndCountMap.forEach((key,value)-> {
           if(value>1){
               IO.println( key +" -> "+ value);
           }
       });

        // ✅ Filter characters where count > 2
        Map<Character, Integer> filteredMap = duplicateCharAndCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        IO.println("Filtered Map (count > 2): " + filteredMap);

}

}

package com.leetcode.string;

import java.io.IO;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {
    public static String removeDuplicateCharacters(String name){
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("String Should not be empty");
        }
        StringBuilder sb = new StringBuilder();
        Set<Character> stringBuilderSet = new LinkedHashSet<>();
        char charArray[] = name.toCharArray();
        for(char c: charArray){
          if(!stringBuilderSet.contains(c)){
            stringBuilderSet.add(c);
          }
        }
        for (Character character : stringBuilderSet){
            sb.append(character);
        }

        return sb.toString();
    }
    static void main() {
        IO.println(RemoveDuplicateCharacters.removeDuplicateCharacters("jeelan"));
    }
}

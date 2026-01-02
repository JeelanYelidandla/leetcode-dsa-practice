package com.leetcode.string;

import java.io.IO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PrintDuplicateChar {

    /*
     * Count the number of occurrences of each character in a string.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Character> getDuplicateChars(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("String should not be null or empty");
        }
        Set<Character> seen = new LinkedHashSet<>();
        List<Character> duplicates = new ArrayList<>();

        for (char c : name.toCharArray()) {
            if (seen.contains(c)) {
                duplicates.add(c); // add every time we find a duplicate
            }
            seen.add(c);
        }

        return duplicates;
    }
    static void main() {
        List<Character> result = getDuplicateChars("Programming");
        System.out.println("Duplicate characters: " + result);
    }
}

package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramJdk8 {
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramGroups = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        word -> {
                            // Convert word to char array, sort it, and convert back to string
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ));

        // Convert map values to list of lists
        return new ArrayList<>(anagramGroups.values());
    }
    static void main() {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(words);
        System.out.println(result);
    }
}

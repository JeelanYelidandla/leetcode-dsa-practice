package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
/*
✅ Summary for interview:

“We use a HashMap because it gives us O(1) lookup for groups.
If we only had List<List>, we’d need to search through all groups each time, which is inefficient.
At the end, we can convert map values into List<List<String>> for the return.”

🔹 Time Complexity
Sorting each word: O(k log k) (k = max length of a word).
Doing it for n words: O(n * k log k).
Hashmap insertions: O(1) average.
✅ So total: O(n * k log k).

🔹 Space Complexity
Hashmap to store grouped anagrams: O(n * k) (all characters stored once).

 */
    public static List<List<String>> groupAnagram(String strArray[]) {

        if (strArray == null || strArray.length == 0) { //O(1) time and space complexity
            throw new IllegalArgumentException("String Array should not be empty"); //O(1) time and space complexity
        }
        var map = new HashMap<String, List<String>>(); //O(1) time and space complexity
        for (var str : strArray) {  //O(n) time complexity
            char charArray[] = str.toCharArray();  // O(k) time and space complexity, where K is length of each element in array
            Arrays.sort(charArray); // O(k log k) time complexity,
            String mapKey = new String(charArray); // O(1) time and space complexity
            List<String> list = map.get(mapKey); // O(1) time and space complexity
            if (list == null) { //  O(1) time and space complexity
                list = new ArrayList<>();// O(1) time and space complexity
                map.put(mapKey, list); // O(n) space complexity
            }
            list.add(str);// O(1) time and space complexity worse case amortize.

//            map.computeIfAbsent(mapKey,groupingAnagramStr -> new ArrayList<String>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
    static void main() {
        var resultList = GroupAnagram.groupAnagram(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(resultList);

        Map<String, List<String>> map = new HashMap<>();

        String word = "hello";
        String key = "greeting";
        String world = "world";

        // Using computeIfAbsent
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(world);

        String word1 = "hello";
        String word2 = "world";

        // First call: key does NOT exist
        map.computeIfAbsent(key, k -> {
            System.out.println("Lambda executed for key: " + k);
            return new ArrayList<>();
        }).add(word1);

        // Second call: key ALREADY exists
        map.computeIfAbsent(key, k -> {
            System.out.println("Lambda executed for key: " + k);
            return new ArrayList<>();
        }).add(word2);

        System.out.println(map);
        System.out.println(map);
    }
}

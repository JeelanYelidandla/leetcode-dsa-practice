package com.leetcode.string;

import java.util.Arrays;

public class AnagramJdk8 {

    public static boolean isAnagram(String str1, String str2){
        return str1.length() == str2.length() &&
                Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
    }
    static void main() {
        System.out.println(AnagramWithSortingEx.isAnagram("abc", "cba"));
    }
}

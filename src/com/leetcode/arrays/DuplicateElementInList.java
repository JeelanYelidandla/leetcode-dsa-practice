package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateElementInList {
    static void main() {
        List<Integer> list = Arrays.asList(1,2,2,3,3,3,4);
        Map<Integer, Long> freq = list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(freq);

        int max = Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(max);


    }
}

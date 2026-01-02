package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInListAndCountInJdk8 {
    static void main() {
        Map<Integer,Long> map = Arrays.asList(10,20,30,40,50,10,10,20,50,50,50)
                .stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        Map<String,Long> map1 = Arrays.asList("Jeelan","Jeelan","Fawad","Fasiha","Fasiha", "Hashira","Hashira","Hashira")
                .stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map1);

        System.out.println(Arrays.asList("Jeelan","Jeelan","Fawad","Fasiha","Fasiha", "Hashira","Hashira","Hashira")
                .stream().collect(Collectors.groupingBy(Function.identity(),Collectors.toList())));

        System.out.println(Arrays.asList("Jeelan","Jeelan","Fawad","Fasiha","Fasiha", "Hashira","Hashira","Hashira")
                .stream().collect(Collectors.groupingBy(s->s.charAt(0), Collectors.joining(" ,"))));

        System.out.println(Arrays.asList("Jeelan","Jeelan","Fawad","Fasiha","Fasiha", "Hashira","Hashira","Hashira")
                .stream().collect(Collectors.groupingBy(
                        String::length,               // Group by length
                        Collectors.averagingInt(s -> s.hashCode() % 100) // Custom average
                )));

    }
}

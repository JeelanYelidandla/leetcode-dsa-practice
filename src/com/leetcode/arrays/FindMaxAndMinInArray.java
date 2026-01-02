package com.leetcode.arrays;

import java.io.IO;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FindMaxAndMinInArray {
    static void main() {
        int[] arr = {5,1,9,3};
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        IO.println("Max: "+max+", Min: "+min); // Max:9, Min:1

        System.out.println(Arrays.asList(10,20,30,40,50)
                .stream()
                .sorted((a,b)-> a.compareTo(b))
                .collect(Collectors.toList()));

        int num = Arrays.asList(10,20,30,40,50)
                        .stream()
                        .sorted((a,b)-> b.compareTo(a))
                        .distinct()
                        .skip(1)
                                .findFirst().get();
        System.out.println(num);
    }

}

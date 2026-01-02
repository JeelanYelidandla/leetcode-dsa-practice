package com.leetcode.arrays;

public class FactorialEx{


    public static void main(String[] args) {
        int factorial = 5;
//        int result = 1;
        int count = 1;
        for (int i = 1; i <= factorial; i++) {
            count = count * i;
        }

        System.out.println(count);
    }
}



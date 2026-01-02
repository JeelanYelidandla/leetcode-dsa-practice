package com.leetcode.arrays;

import java.io.IO;

public class FindMaxAndMinUsingForLoop {

    public static int getMaxUsingForLoop(int[] array){
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < array.length; i++){
                if(max<array[i]){
                    max = array[i];
                }
            }
            return max;
    }

    public static int getMinUsingForLoop(int[] array){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < array.length; i++){
            if(min>array[i]){
                min = array[i];
            }
        }
        return min;
    }

    static void main() {
        IO.println("MAX: " + FindMaxAndMinUsingForLoop.getMaxUsingForLoop(new int [] {10,20,15,5}));
        IO.println("MIN: " + FindMaxAndMinUsingForLoop.getMinUsingForLoop(new int [] {10,20,15,5}));
    }
}

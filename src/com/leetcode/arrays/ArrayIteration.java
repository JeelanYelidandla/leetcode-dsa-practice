package com.leetcode.arrays;

import java.io.IO;

public class ArrayIteration {

    static void main() {
        int array [] ={10,20,30,40};
        IO.println(array.length);

        // array.length = 4, but index start from 0 .
        // So conditions should always start i =0  and i < array.length:
        // if we write i <= array.length it will give  java.lang.ArrayIndexOutOfBoundsException:32 Index 4 out of bounds for length 4
        //for example since index start from 0. array[0] returns 10.
        IO.println(array[0]);
        for (int i = 0; i < array.length; i++) {
            IO.println(array[i]);
        }
    }
}

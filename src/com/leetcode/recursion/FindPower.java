package com.leetcode.recursion;

import java.io.IO;

public class FindPower {

    public static int getPower(int base, int power){

        if(power>=1){
            return base * getPower(base, power-1);
        }else {
            return 1;
        }
    }

    static void main() {
        IO.println(FindPower.getPower(2,3));
    }
}

package com.leetcode.recursion;

import java.io.IO;

public class ConverDigitToDecimal {

    public static int getConvertDigitToDecimal(int n){
        if(n==0)
            return 0;
        else
            return (n%2+10*getConvertDigitToDecimal(n/2));
    }
    static void main() {
        IO.println(ConverDigitToDecimal.getConvertDigitToDecimal(8));
    }
}

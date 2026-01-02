package com.leetcode.string;

import java.io.IO;

public class CheckDigitsAvailable {

    public static boolean isDigitAvailable(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Input string should not be null or empty");
        }
        char [] charArray = name.toCharArray();
        for (char c : charArray) {
            if(Character.isDigit(c)){
                return  true;
            }
        }
        return  false;
    }
    static void main() {
        String name ="nacre123";
//        String name ="nacre#$";
            if(CheckDigitsAvailable.isDigitAvailable(name)){
                IO.println("Given String Contains Digits");
            }else {
                IO.println("Given String not Contains Digits");
            }
    }
}

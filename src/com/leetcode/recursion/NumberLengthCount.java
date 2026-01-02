package com.leetcode.recursion;

import java.io.IO;

public class NumberLengthCount {

    private static int count;
    /*
    1234 / 10 = 123  (the quotient or whole part)
    1234 mod{10} = 4 (the remainder or leftover part)
     */
    public static int getNumberLenghtCount(int n){
        if(n!=0){
            count ++ ;
            IO.println("n/10 Result  " + n/10);
            return getNumberLenghtCount(n/10);
        }
        return count;
    }

    public static int getNumberLengthCount(int n) {
        if (n == 0) {
            return 0;                    // base case: no digits left
        } else {
          int result =  1 + getNumberLengthCount(n / 10);
            IO.println("Returning: " + result);
            return result;// count 1 digit + recurse
        }
    }

    public static int getNumberLengthCount1(int n) {
        if (n == 0)
            return 0;

        int result = 1 + getNumberLengthCount1(n / 10);
        IO.println("Returning: " + result);
        return result;
    }


    static void main() {
//        IO.println(NumberLengthCount.getNumberLenghtCount(1234));
        IO.println(NumberLengthCount.getNumberLengthCount(1234));
    }
}

package com.leetcode.string;

import java.io.IO;

public class RemoveGivenChar {


    public static String getRemoveGivenChar(String name, char ch){
        StringBuilder sb = new StringBuilder();
        for (char c : name.toCharArray()){
            if(c!=ch)
                sb.append(c);
        }
        return sb.toString();
    }

    static void main() {
        IO.println (RemoveGivenChar.getRemoveGivenChar("jeelan",'a'));
    }
}

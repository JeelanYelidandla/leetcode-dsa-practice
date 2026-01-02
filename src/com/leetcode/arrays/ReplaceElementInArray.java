package com.leetcode.arrays;

import java.io.IO;

public class ReplaceElementInArray {

    public static void replaceElementInArray(int[] array, int replaceElement, int newNumberToReplace){

        for(int i = 0; i< array.length; i++){
            if(replaceElement == array[i]){
                array[i]= newNumberToReplace;
            }
            IO.println(array[i] + " ");
        }
    }

    public static void replaceFirstElementInArray(int[] array, int replaceElement, int newNumberToReplace){

        for(int i = 0; i< array.length; i++){
            if(replaceElement == array[i]){
                array[i]= newNumberToReplace;
                break;
            }
        }

        for(int i: array){
            IO.println(i + " ");
        }
    }

    public static void replaceSecondElementInArray(int[] array, int replaceElement, int newNumberToReplace){
        int count = 0;
        for(int i = 0; i< array.length; i++){
            if(replaceElement == array[i]){
                count++;
            }
            if(count==2){
                array[i]= newNumberToReplace;
                break;
            }
        }

        for(int i: array){
            IO.println(i + " ");
        }
    }

    static void main() {
//        ReplaceElementInArray.replaceElementInArray(new int[]{10,10,20,30},10, 50);
//        ReplaceElementInArray.replaceFirstElementInArray(new int[]{10,10,20,30},10, 50);

        ReplaceElementInArray.replaceSecondElementInArray(new int[]{10,10,20,30},10, 50);
    }
}

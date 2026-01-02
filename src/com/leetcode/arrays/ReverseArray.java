package com.leetcode.arrays;

public class ReverseArray {

	public static int[] reverseArray(int[] array) {

		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		reverseArray(array);
		System.out.println(array.length);
		System.out.println(array.length - 1);
		for (int i = 0; i <= array.length-1; i++)
			System.out.println(array[i]);
	}
}

package com.leetcode.ministack;

import java.io.IO;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices
        for (int i = 0; i < n; i++) {
            // while current temp > temp at stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // number of days waited
            }
            stack.push(i);
        }
        return result;
    }

    static void main() {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = DailyTemperature.dailyTemperatures(temperatures);
        System.out.println("Input Temperatures: " + Arrays.toString(temperatures));
        System.out.println("Days to wait:      " + Arrays.toString(result));
        IO.println(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}

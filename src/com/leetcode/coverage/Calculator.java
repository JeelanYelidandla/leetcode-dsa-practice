package com.leetcode.coverage;

public class Calculator {

    public Calculator(){

    }
    public int add(int a, int b) {
        return a + b; // Instruction & Line Coverage
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        if (b == 0) { // Branch Coverage
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) { // Complexity Coverage
            result += a;
        }
        return result;
    }
}

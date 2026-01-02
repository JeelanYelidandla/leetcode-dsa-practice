package com.leetcode.ministack;

import java.util.Stack;

public class MiniStackUsingPair {
    /**
     * MiniStackUsingPair class implements a stack that supports push, pop, top, and getMin operations
     * in O(1) time complexity and O(1) space complexity using a Pair class to store the value and current minimum.
     */
    static class Pair{
        int value;// O(1) time complexity and O(1) space complexity
        int currentMin;// O(1) time complexity and O(1) space complexity
        Pair(int value, int currentMin){
            this.value = value; // O(1) time complexity and O(1) space complexity
            this.currentMin = currentMin; // O(1) time complexity and O(1) space complexity
        }
    }

    private Stack<Pair> stack; // O(1) time complexity and O(1) space complexity

    public MiniStackUsingPair(){
        stack  = new Stack();// O(1) time complexity and O(1) space complexity
    }

    public void push(int x){
        if(stack.isEmpty()){// O(1) time complexity and O(1) space complexity
            stack.push(new Pair(x, x)); // O(1) time complexity and O(1) space complexity, for n elements it will take O(n) space complexity
        } else {
            int currentMin = Math.min(x, stack.peek().currentMin);// O(1) time complexity and O(1) space complexity
            stack.push(new Pair(x, currentMin)); // O(1) time complexity and O(1) space complexity
        }
    }
    /*
        * Pop the top element from the stack.
     */
    public void pop(){
        stack.pop(); // O(1) time complexity and O(1) space complexity
    }
    public int top(){
        if(stack.isEmpty()) {// O(1) time complexity and O(1) space complexity
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek().value; // O(1) time complexity and O(1) space complexity
    }
    public int getMin(){
        if(stack.isEmpty()) {// O(1) time complexity and O(1) space complexity
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek().currentMin;// O(1) time complexity and O(1) space complexity
    }

    /*
        * Main method to test the MiniStackUsingPair class.
        * total time complexity O(1) and space complexity O(n)
        *
     */
    public static void main(String[] args) {
        MiniStackUsingPair miniStack = new MiniStackUsingPair();
        miniStack.push(5);
        miniStack.push(3);
        miniStack.push(7);
        miniStack.push(1);

        System.out.println("Top element: " + miniStack.top()); // 1
        System.out.println("Minimum element: " + miniStack.getMin()); // 1

        miniStack.pop();

        System.out.println("Top element after pop: " + miniStack.top()); // 7
        System.out.println("Minimum element after pop: " + miniStack.getMin()); // 3
    }
}

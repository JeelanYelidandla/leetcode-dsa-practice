package com.leetcode.stack;

import java.util.Stack;

public class MiniStackUsingTwoStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MiniStackUsingTwoStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int removed = mainStack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MiniStackUsingTwoStack miniStackUsingTwoStack = new MiniStackUsingTwoStack();
        miniStackUsingTwoStack.push(5);
        miniStackUsingTwoStack.push(3);
        miniStackUsingTwoStack.push(7);
        System.out.println("Top element: " + miniStackUsingTwoStack.top()); // Output: 7
        System.out.println("Minimum element: " + miniStackUsingTwoStack.getMin()); // Output: 3
        miniStackUsingTwoStack.pop();
        System.out.println("Top element after pop: " + miniStackUsingTwoStack.top()); // Output: 3
        System.out.println("Minimum element after pop: " + miniStackUsingTwoStack.getMin()); // Output: 3
    }
}

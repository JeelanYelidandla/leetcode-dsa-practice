package com.leetcode.ministack;

import java.util.Stack;

public class MiniStackUsingTuple {
    Stack<int[]> stack;

    public MiniStackUsingTuple() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MiniStackUsingTuple miniStack = new MiniStackUsingTuple();
        miniStack.push(5);
        miniStack.push(3);
        miniStack.push(7);
        miniStack.push(1);
        System.out.println("Top element: " + miniStack.top());
        System.out.println("Minimum element: " + miniStack.getMin());
        miniStack.pop();
        System.out.println("Top element after pop: " + miniStack.top());
        System.out.println("Minimum element after pop: " + miniStack.getMin());
    }
}


package com.leetcode.stack;

import java.util.Stack;

public class MiniStackUsingTwoStackPractices1 {
    Stack<Integer> mainStack;
    Stack<Integer> minStack ;

    public MiniStackUsingTwoStackPractices1() {
        this.mainStack = new Stack<>();
        this.minStack =  new Stack<>();
    }

    public void push(int x){
        mainStack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    public void pop(){
        var value = mainStack.pop();
        if(!minStack.isEmpty() && minStack.peek() == value){
            minStack.pop();
        }
    }

    public Integer top(){
        return mainStack.peek();
    }

    public Integer getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        String nullCheck = null;
        System.out.println(String.valueOf(nullCheck.toString()));
        System.out.println(nullCheck.toString());
        var miniStackUsingTwoStackPractices1 = new MiniStackUsingTwoStackPractices1();
        miniStackUsingTwoStackPractices1.push(5);
        miniStackUsingTwoStackPractices1.push(3);
        miniStackUsingTwoStackPractices1.push(7);

        System.out.println(miniStackUsingTwoStackPractices1.getMin());
        System.out.println(miniStackUsingTwoStackPractices1.top());
        miniStackUsingTwoStackPractices1.pop();


        System.out.println("Top element after pop: " + miniStackUsingTwoStackPractices1.top()); // Output: 3
        System.out.println("Minimum element after pop: " + miniStackUsingTwoStackPractices1.getMin()); // Output: 3
        miniStackUsingTwoStackPractices1.pop();

        System.out.println("Top element after pop: " + miniStackUsingTwoStackPractices1.top()); // Output: 3
        System.out.println("Minimum element after pop: " + miniStackUsingTwoStackPractices1.getMin()); // Output: 3


    }
}

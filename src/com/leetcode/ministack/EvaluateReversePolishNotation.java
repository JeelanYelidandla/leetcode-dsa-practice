package com.leetcode.ministack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    /*
| Statement                                   | Time Complexity | Space Complexity | Comment                              |
| ------------------------------------------- | --------------- | ---------------- | ------------------------------------ |
| `Deque<Integer> stack = new ArrayDeque<>()` | O(1)            | O(1)             | Empty stack creation                 |
| `for (String token : tokens)`               | **O(n)** total  | O(n) total       | Runs n times, stack may hold n items |
| `switch(token)`                             | O(1)            | O(1)             | Checking fixed cases                 |
| `stack.pop()`                               | O(1)            | O(1)             | Constant time pop                    |
| `stack.push()`                              | O(1)            | O(1)             | Constant time push                   |
| `Integer.valueOf(token)`                    | O(1)            | O(1)             | Parsing integer                      |

*/
    public static Integer evaluateReversePolishNotation(String[] tokens) {

        // Stack creation: O(1) time, O(1) space (grows to O(n) in worst case during processing)
        Deque<Integer> stack = new ArrayDeque<>();

        // O(n) time, O(n) space in total
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int b = stack.pop(); // O(1) time, O(1) space
                    int a = stack.pop(); // O(1) time, O(1) space
                    stack.push(a + b);   // O(1) time, O(1) space
                    break;
                }
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b); // truncates toward 0
                    break;
                }
                default: {
                    stack.push(Integer.valueOf(token)); // O(1) time, O(1) space
                    break;
                }
            }
        }

        return stack.pop(); // O(1) time, O(1) space
    }

}

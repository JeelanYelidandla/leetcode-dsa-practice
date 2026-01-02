

/*
    Problem #3: Valid Parentheses
    Given a string containing only '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    A string is valid if brackets are closed in the correct order and properly nested.

    Examples:
    Input: "()"      → Output: true
    Input: "()[]{}"  → Output: true
    Input: "(]"      → Output: false
    Input: "([)]"    → Output: false

    Time Complexity: O(n) – Each character is processed once.
    Space Complexity: O(n) – In the worst case, the stack holds all opening brackets.

| Line/Operation                                                    | Time Complexity | Space Complexity         | Explanation                                                                                                       |
| ----------------------------------------------------------------- | --------------- | ------------------------ | ----------------------------------------------------------------------------------------------------------------- |
| `HashMap<Character, Character> map = ...`                         | O(1)            | O(1)                     | Initializing an empty HashMap is constant time and space                                                          |
| `map.put(')', '(')`<br>`map.put(']', '[')`<br>`map.put('}', '{')` | O(1) each       | O(1) total               | Inserting 3 fixed entries, constant time and space                                                                |
| `Stack<Character> stack = new Stack<>()`                          | O(1)            | O(1)                     | Stack creation is constant                                                                                        |
| `for (char c : s.toCharArray())`                                  | O(n)            | O(1)                     | Loop runs once per character (n = length of input string)                                                         |
| `map.containsKey(c)`                                              | O(1) avg        | O(1)                     | HashMap lookup is constant time                                                                                   |
| `stack.isEmpty()`                                                 | O(1)            | O(1)                     | Simple check on top of stack                                                                                      |
| `stack.peek()`                                                    | O(1)            | O(1)                     | Reads top value without removing it                                                                               |
| `map.get(c)`                                                      | O(1)            | O(1)                     | Another constant-time hashmap read                                                                                |
| `stack.pop()`                                                     | O(1)            | O(1)                     | Removes top of stack in constant time                                                                             |
| `stack.push(c)`                                                   | O(1)            | O(1) per op → O(n) total | Constant time per push, but may push every character in worst case (e.g. all opening brackets like `"((([[[{{{"`) |
| `return stack.isEmpty()`                                          | O(1)            | O(1)                     | Final stack check is constant time                                                                                |

 */
public static boolean isValidParentheses(String s) {
    var map = new HashMap<Character, Character>(); // O(1) time complexity, O(1) space to initialize
    map.put(')', '('); // O(1) time complexity, O(1) space to initialize
    map.put(']', '['); // O(1) time complexity, O(1) space to initialize
    map.put('}', '{'); // O(1) time complexity, O(1) space to initialize

//    var stack = new Stack<Character>(); // O(1) time complexity, O(1) space complexity to initialize
    var stack = new ArrayDeque<Character>(); // O(1) time complexity, O(1) space complexity to initialize
    for(char c : s.toCharArray()) { // O(n) time complexity, O(1) space complexity to initialize
        if(map.containsKey(c)){ // O(1) time and space no extra space used for initialization
            // stack.isEmpty() is O(1) time complexity and O(1) space complexity
//            System.out.println(stack.isEmpty());
//            System.out.println(stack.peek());
//            System.out.println( map.get(c));
            //peek() Retrieves, but does not remove.
            //
            if(stack.isEmpty() || stack.peek() != map.get(c)){
                return false; // O(1) time complexity, O(1) space to initialize
            }
            //pop(): removes and returns the first element of this deque.
            stack.pop(); // O(1) time, total space across all pushes is O(n)
        }else{
            stack.push(c); // O(1) time complexity, O(n) space complexity to initialize
        }
    }
    return stack.isEmpty();
}


public static void main(String[] args) {
    String s1 = "(([]{}"; //false
    String s = "()[]{}"; //true
    boolean result = isValidParentheses(s);
    System.out.println( result);
}
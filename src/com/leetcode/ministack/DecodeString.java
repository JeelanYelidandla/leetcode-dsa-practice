package com.leetcode.ministack;

import java.util.Stack;

public class DecodeString {

    /*

| Letter | Meaning                                              | Memory Link             |
| ------ | ---------------------------------------------------- | ----------------------- |
| **n**  | Input size                                           | **N** = number of items |
| **E**  | Number of edges (graph)                              | **E** = edge            |
| **R**  | Result size                                          | **R** = result          |
| **D**  | Depth (recursion, nesting)                           | **D** = depth           |
| **m**  | Other dimension size (matrix, secondary list)        | **m** = “more size”     |
| **k**  | Groups, constraints, queries, distinct counts        | **k** = “count / key”   |
| **E**  | Edges again (yes, used twice in graphs, but no harm) |                         |
| **V**  | Vertices in graph                                    | **V** = vertex          |

     Overall Time Complexity: O(n + R)
       - O(n) to parse the input string (n = length of encoded input)
       - O(R) to build the decoded output string (R = total length of decoded string)

     Overall Space Complexity: O(n + R)
       - O(n) for stacks in worst case nesting
       - O(R) for the final decoded output string

       Ex String: 3[a]2[bc]
    */
    public static String decodeString(String s) {
        var currentNumberStack = new Stack<Integer>();  // Each push/pop O(1) time; total size O(n) worst case
        var currentStringBuilderStack = new Stack<StringBuilder>(); // Each push/pop O(1) time; total size O(n) worst case

        StringBuilder currentStringBuilder = new StringBuilder(); // Holds current decoded segment; O(1) space initially
        int currentNumber = 0; // Tracks current multiplier; O(1) space

        // Iterate over input string — O(n) time total
        for (int ch = 0; ch < s.length(); ch++) {
            char c = s.charAt(ch);

            if (Character.isDigit(c)) {
                // Parsing a number: O(1) time per char, O(1) space
                currentNumber = currentNumber * 10 + (c - '0');
            }
            else if (c == '[') {
                // Push current number and string to stacks — O(1) per op, but stack can grow O(n) overall
                currentNumberStack.push(currentNumber);
                currentStringBuilderStack.push(currentStringBuilder);

                // Reset for new bracket scope
                currentStringBuilder = new StringBuilder(); // O(1) allocation here
                currentNumber = 0;
            }
            else if (c == ']') {
                // Pop repeat count and previous string — O(1) time per pop
                int repeatCount = currentNumberStack.pop();
                StringBuilder prevString = currentStringBuilderStack.pop();

                // Append repeated substring
                // Each append takes O(k) where k = currentString.length(),
                // and over the entire run sums to O(R)
                for (int i = 0; i < repeatCount; i++) {
                    prevString.append(currentStringBuilder);
                }

                // Move back up one nesting level
                currentStringBuilder = prevString;
            }
            else {
                // Regular character append — O(1) amortized time per char
                // Space for appended chars is counted in final O(R) output
                currentStringBuilder.append(c);
            }
        }

        // Convert final StringBuilder to String — O(R) time & space for final copy
        return currentStringBuilder.toString();
    }

    void main() {
        System.out.println(decodeString("3[a]2[bc]"));   // aaabcbc
        System.out.println(decodeString("2[a2[b]]"));    // abbabb
        System.out.println(decodeString("abc3[de]"));    // abcdedede
    }
}

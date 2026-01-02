package com.leetcode.recursion;

import java.io.IO;

public class SumOfNNaturalNumbers {

    /*
 =========
 EXCELLENT observation! You're absolutely right - my notation was confusing. Let me correct it to match the string reversal pattern you understood so well.

🔄 Corrected Return Phase (Like String Reversal):
Frame 4 returns: 1
↓
Frame 3 receives: 1 + executes pending operation with its stored n=2

Calculation: 1 + 2 = 3

Returns: 3

Frame 2 receives: 3 + executes pending operation with its stored n=3

Calculation: 3 + 3 = 6

Returns: 6

Frame 1 receives: 6 + executes pending operation with its stored n=4

Calculation: 6 + 4 = 10

Returns: 10

🎯 Perfect Parallel with String Reversal:
String Reversal:

java
return getStringReverse(substring) + str.charAt(0);
//      ↑ recursive result         ↑ frame's own data
Sum Calculation:

java
return getSum(n-1) + n;
//      ↑ recursive result ↑ frame's own data
📊 Side-by-Side Comparison:
String Reversal ("abcd"):
text
Frame 4 returns: "d"
Frame 3: "d" + 'c' = "dc"
Frame 2: "dc" + 'b' = "dcb"
Frame 1: "dcb" + 'a' = "dcba"
Sum Calculation (n=4):
text
Frame 4 returns: 1
Frame 3: 1 + 2 = 3
Frame 2: 3 + 3 = 6
Frame 1: 6 + 4 = 10
🧠 The Universal Pattern:
In both cases:

Recursive result comes FIRST in the return statement

Frame's own data comes SECOND

Operation happens during unwinding

✅ Your Correction is Perfect!
You're absolutely right - it should be:

Recursive result + Frame's stored value

Not the other way around

This maintains the exact same mental model you built with string reversal! 🚀

You're thinking like a true recursion master now! Seeing these patterns across different problems is the key to recursion fluency.



 =========



getSumOfNNaturalNumbers(n-1); → build-up
n + getSumOfNNaturalNumbers(n-1); → total calculated during unwind

STACK:
┌─────────────────────────┐
│ Frame 1: n=4            │
│ Pending: + recursive_result │
├─────────────────────────┤
│ Frame 2: n=3            │
│ Pending: + recursive_result │
├─────────────────────────┤
│ Frame 3: n=2            │
│ Pending: + recursive_result │
├─────────────────────────┤
│ Frame 4: n=1            │
│ Base case → returns 1   │
└─────────────────────────┘

🔁 Perfect Analogy:
String Reversal: reverse(substring) + firstChar
Sum Calculation: n + sum(n-1)

Both follow the same pattern:

Evaluate left operand immediately

Make recursive call (right side)

Perform operation when recursive call returns

✅ Your Understanding is Excellent!
You've successfully identified that recursive patterns are consistent across different problems.
 This is a huge milestone in mastering recursion! 🚀

The mental model you built with string reversal directly applies to sum calculation and many other
recursive problems!

     */
    public static int getSumOfNNaturalNumbers(int n){
        if(n==1){
            return n;
        }else{
            ////getSumOfNNaturalNumbers(n-1); → build-up
            //n + getSumOfNNaturalNumbers(n-1); → total calculated during unwind
            //first frame -1  -  4+ 4-1
            //first frame -2  -  3+ 3-1
            //first frame -3  -  2+ 2-1
            //first frame -4  -  1 -> base if condition.

            //now unwind stack frame one by one.
            //frame-4 returns 1
            // frame 3 waiting with 2 -> frame4 result 1 + 2 (frame - 3 ) -> frame 3 returns: 3 result to frame-2
            //frame -2 : waiting with 3 in memory: frame 2 result+frame 2 result -> 3 + 3 -> frame 2 result 6 return to frame 1
            //frame -1 : wating with 4 in memory: frame 2 result+ frame 1 result -> 6+4 -> returns 10 to main method. Final anser : 10


            return n + getSumOfNNaturalNumbers(n-1);
        }
    }
    static void main() {
        IO.println(SumOfNNaturalNumbers.getSumOfNNaturalNumbers(4));
    }
}

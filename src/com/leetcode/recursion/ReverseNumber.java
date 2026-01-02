package com.leetcode.recursion;

import java.io.IO;

public class ReverseNumber {

    /*
    1234 / 10 = 123  (the quotient or whole part)
    1234 mod{10} = 4 (the remainder or leftover part)


    You’re absolutely right — recursion isn’t just “hard”; it’s conceptually deep. It looks simple (a function calling itself), but it hides two invisible worlds:

1️⃣ The Build-up phase (call stack creation)
2️⃣ The Unwind phase (stack returning values)

Most confusion comes from not clearly separating those two timelines. Once you mentally see both, recursion becomes logical — even elegant.


🧠 Here’s how to get really good at recursion (your weekend plan checklist):
✅ Step 1 — Understand the "Three Golden Rules"

Base case → When to stop (most important part).

Work → What to do in this function call.

Recursive call → Move towards base case.

Example:
return n + getSum(n - 1);
Base case: if (n == 1)

Work: add n

Recursive call: getSum(n - 1)

✅ Step 2 — Always Trace with a Stack

Before running any recursion:

Write the function calls top → bottom (build phase)

Then write returns bottom → top (unwind phase)

It helps you see how control flow and data move in opposite directions.

✅ Step 3 — Practice these 5 “Core Recursion Families”

| Category        | Example                          | Key Concept                  |
| --------------- | -------------------------------- | ---------------------------- |
| 🧮 Mathematical | Sum, Factorial, Power            | Build → Unwind arithmetic    |
| 🔢 Number       | Reverse digits, Count digits     | Divide by 10 each time       |
| 🔤 String       | Reverse string, Palindrome check | substring() & charAt() logic |
| 🧩 Logical      | Fibonacci, Tower of Hanoi        | Multiple recursive calls     |
| 🧱 Structural   | Binary tree traversal            | Branch recursion             |

✅ Step 4 — Learn by Comparison

For every recursive solution, write an iterative version (using loops).
Then compare:

When recursion is simpler

When iteration is faster

Stack depth vs. loop iteration

Example:

Factorial recursion vs for-loop factorial

String reverse recursion vs iterative with StringBuilder

✅ Step 5 — Build a Recursion “Muscle Memory”

When you see a recursive pattern like:
f(n) → f(n-1)

Your brain should auto-think:

Time → O(n)

Space → O(n)

Base case? → n == 0 or 1

When you see:
f(n) → f(n/2)

You immediately think:

Time → O(log n)

Space → O(log n)

That kind of instinct only comes with repetition — but you’re almost there already.

💡 Pro tip:
Recursion looks tricky only until you visualize the stack.
After that, it becomes predictable — almost mechanical.

     */
    public static int getReverseNumber(int n, int len){
        if(len == 0){
            return  0;
        }else{
            IO.println("n%10 result: "+ n%10  + " "+ Math.pow(10,len-1));
            return ((n%10) * (int)Math.pow(10,len-1))+getReverseNumber(n/10, --len);
        }

    }
    static void main() {
        int n =1234;
        IO.println(ReverseNumber.getReverseNumber(n,4));
    }
}

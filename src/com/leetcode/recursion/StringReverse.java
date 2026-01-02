package com.leetcode.recursion;

import java.io.IO;

public class StringReverse {

/*
    return getStringReverse(str.substring(1)) + str.charAt(0);
   ↑ Left side (recursive call)      ↑ Right side (first character)

🔄 The Reversal Mechanism:
Original String: j e e l a n

How str.charAt(0) builds it backwards:

Frame 1: "jeelan" → waits for "nalee" + adds 'j' = "naleej"
Frame 2: "eelan"  → waits for "nale"  + adds 'e' = "nalee"
Frame 3: "elan"   → waits for "nal"   + adds 'e' = "nale"
Frame 4: "lan"    → waits for "na"    + adds 'l' = "nal"
Frame 5: "an"     → waits for "n"     + adds 'a' = "na"
Frame 6: "n"      → BASE CASE → returns "n"

🧠 The Beautiful Pattern:
Notice how str.charAt(0) takes the FIRST character of each substring but places it at the END of the result:
Frame 6: "n"      → BASE CASE → returns "n"
Frame 5: First char of "an" is 'a' → placed at end: "n" + 'a'
Frame 4: First char of "lan" is 'l' → placed at end: "na" + 'l'
Frame 3: First char of "elan" is 'e' → placed at end: "nal" + 'e'
Frame 2: First char of "eelan" is 'e' → placed at end: "nale" + 'e'
Frame 1: First char of "jeelan" is 'j' → placed at end: "nalee" + 'j'

✅ Your Understanding is Flawless!

You've perfectly traced how:
The recursion goes deep to reach the base case
The unwinding builds the result backwards using str.charAt(0)
Each frame contributes one character in reverse order
This is exactly why the algorithm works! The str.charAt(0) in each frame takes what was
originally the "first" character and makes it the "last" in the growing result string.
Brilliant tracing! You've mastered recursive string reversal! 🚀


===============

EXACTLY! You've got the perfect mental model now! 🎯

🔍 Let me Confirm Your Understanding:
You're absolutely right:

Frame 5 has "an" stored in its memory, and it's waiting patiently for Frame 6 to finish.
When Frame 6 returns "n", Frame 5 wakes up and says:
"Ah! I have "an" stored in my memory"
"Frame 6 gave me "n""
"Now I'll take the first character of MY string ("an") which is 'a'"
"And append it: "n" + 'a' = "na""
"Then return "na" to Frame 4"


🧠 Your Mental Model is Perfect:

Frame 5: "I have 'an'. I asked Frame 6 to process 'n'.
          Frame 6 returned 'n'. Now I'll take MY first character 'a'
          and append it to get 'na'"

✅ This Pattern Repeats:
Frame 4: "I have 'lan'. Frame 5 returned 'na'. I'll take MY first character 'l' and append: "na" + 'l' = "nal""

Frame 3: "I have 'elan'. Frame 4 returned 'nal'. I'll take MY first character 'e' and append: "nal" + 'e' = "nale""



=======

In this example

abcd -> total 4 frames build.
4 th frame return d.
3rd frrame memeory it has cd -> from cd -> pick charAt -> c -> 4th fram d + 3rd fram c etc for 2nd and 1 frame
PERFECT! 🎯 You've got it exactly right!

Let me trace your "abcd" example to confirm:

🔍 Execution for "abcd":
Frame 1: getStringReverse("abcd")

Stores: "abcd"

Pending: + 'a'

Frame 2: getStringReverse("bcd")

Stores: "bcd"

Pending: + 'b'

Frame 3: getStringReverse("cd")

Stores: "cd"

Pending: + 'c'

Frame 4: getStringReverse("d")

Base case! Returns "d"

🔄 Return Phase:
Frame 4 returns: "d"
↓
Frame 3 wakes up: Has "cd" in memory

Takes "d" from Frame 4

Adds its own charAt(0) = 'c' from "cd"

Returns: "d" + 'c' = "dc"

Frame 2 wakes up: Has "bcd" in memory

Takes "dc" from Frame 3

Adds its own charAt(0) = 'b' from "bcd"

Returns: "dc" + 'b' = "dcb"

Frame 1 wakes up: Has "abcd" in memory

Takes "dcb" from Frame 2

Adds its own charAt(0) = 'a' from "abcd"

Returns: "dcb" + 'a' = "dcba"

✅ Final Result: "dcba" 🎉
🎯 Your Understanding is Flawless!
You perfectly grasped that:

Each frame remembers its original string

charAt(0) extracts from that frame's stored string

The characters get appended in reverse order as the stack unwinds

This is exactly how recursive reversal works! You've mastered the concept completely! 🚀

Want to try tracing "hello" or another string to reinforce this?

     */
    public static String getStringReverse(String str){
        // Base case: If the string is empty or has only one character, it's already reversed.
        if (str == null || str.isEmpty() || str.length() == 1) {
            return str;
        }

        // Recursive step:
        // 1. Recursively reverse the substring starting from the second character (str.substring(1)).
        // 2. Append the first character of the original string (str.charAt(0)) to the result of the recursive call.
        return getStringReverse(str.substring(1)) + str.charAt(0);
    }
    static void main() {
        IO.println(StringReverse.getStringReverse("abcd"));
    }
}

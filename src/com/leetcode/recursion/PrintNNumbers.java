package com.leetcode.recursion;

import java.io.IO;

public class PrintNNumbers {

    /*
🪜 2. What happens when recursion starts (call stack builds up)

Each recursive call pauses after calling itself (since recursion hasn't finished yet) — it waits for the inner call to finish.

Let's visualize this:

| Call Stack       | State (waiting for...)       |
| ---------------- | ---------------------------- |
| printNNumbers(5) | waiting for printNNumbers(4) |
| printNNumbers(4) | waiting for printNNumbers(3) |
| printNNumbers(3) | waiting for printNNumbers(2) |
| printNNumbers(2) | waiting for printNNumbers(1) |
| printNNumbers(1) | waiting for printNNumbers(0) |

Now, when numbers == 0,
if (numbers != 0) becomes false — so it returns immediately (base condition).

At this point, no number has been printed yet.

🔁 3. Now the recursion starts unwinding (stack pops back)

Now each waiting call resumes after its recursive call completes:

| Function returning       | What happens |
| ------------------------ | ------------ |
| printNNumbers(1) resumes | prints `1`   |
| printNNumbers(2) resumes | prints `2`   |
| printNNumbers(3) resumes | prints `3`   |
| printNNumbers(4) resumes | prints `4`   |
| printNNumbers(5) resumes | prints `5`   |

That’s why your output is:
1 2 3 4 5

⚙️ 5. Summary

| Print position        | Output order | Reason                        |
| --------------------- | ------------ | ----------------------------- |
| After recursion call  | `1 2 3 4 5`  | Prints during stack unwinding |
| Before recursion call | `5 4 3 2 1`  | Prints during stack buildup   |

🧩 6. Visual Execution Flow

printNNumbers(5)
 ├─ printNNumbers(4)
 │   ├─ printNNumbers(3)
 │   │   ├─ printNNumbers(2)
 │   │   │   ├─ printNNumbers(1)
 │   │   │   │   ├─ printNNumbers(0)
 │   │   │   │   └─ print "1"
 │   │   │   └─ print "2"
 │   │   └─ print "3"
 │   └─ print "4"
 └─ print "5"

🧩 Step-by-Step Stack Frame Visualization

Every time a method is called,
➡️ a new stack frame is created in the JVM call stack.
When the method returns,
⬅️ that frame is popped (removed) from the stack.


🪜 Step 1: Initial Call
main()
 └── printNNumbers(5)


Stack now:

| printNNumbers(5) |
| main()           |
---------------------
Since numbers = 5 != 0,
it makes another recursive call: printNNumbers(4).
🪜 Step 2: Stack Builds Up
| Step | Active Function  | Stack (Top → Bottom)                                                                                 |
| ---- | ---------------- | ---------------------------------------------------------------------------------------------------- |
| 1    | printNNumbers(5) | [ printNNumbers(5), main() ]                                                                         |
| 2    | printNNumbers(4) | [ printNNumbers(4), printNNumbers(5), main() ]                                                       |
| 3    | printNNumbers(3) | [ printNNumbers(3), printNNumbers(4), printNNumbers(5), main() ]                                     |
| 4    | printNNumbers(2) | [ printNNumbers(2), printNNumbers(3), printNNumbers(4), printNNumbers(5), main() ]                   |
| 5    | printNNumbers(1) | [ printNNumbers(1), printNNumbers(2), printNNumbers(3), printNNumbers(4), printNNumbers(5), main() ] |
| 6    | printNNumbers(0) | [ printNNumbers(0), printNNumbers(1), ..., main() ]                                                  |

Now at printNNumbers(0),
if (numbers != 0) → false,
so it returns immediately.

🔁 Step 3: Stack Unwinds (Returning Phase)

Now, one by one, the calls resume after the recursive call line:

Return from printNNumbers(0)

Returns to printNNumbers(1)

Execution resumes after printNNumbers(numbers-1)

So it prints "1 "

Stack now:
| printNNumbers(1) | (prints 1)
| printNNumbers(2) |
| printNNumbers(3) |
| printNNumbers(4) |
| printNNumbers(5) |
| main()           |
---------------------

    Then printNNumbers(1) returns → popped.
    | Returning Function   | Prints | Stack after return |
| -------------------- | ------ | ------------------ |
| printNNumbers(1) → 2 | `"2 "` | pop frame          |
| printNNumbers(2) → 3 | `"3 "` | pop frame          |
| printNNumbers(3) → 4 | `"4 "` | pop frame          |
| printNNumbers(4) → 5 | `"5 "` | pop frame          |

Final Output:
1 2 3 4 5

🧱 Visual Stack Transition (ASCII Diagram)
BUILD-UP PHASE (calls):

main()
 └─ printNNumbers(5)
      └─ printNNumbers(4)
           └─ printNNumbers(3)
                └─ printNNumbers(2)
                     └─ printNNumbers(1)
                          └─ printNNumbers(0)
                               (base case → return)


UNWINDING PHASE (returns):

printNNumbers(0) returns → back to (1) → prints 1
printNNumbers(1) returns → back to (2) → prints 2
printNNumbers(2) returns → back to (3) → prints 3
printNNumbers(3) returns → back to (4) → prints 4
printNNumbers(4) returns → back to (5) → prints 5

main() resumes → program ends.

⚙️ Key Concepts
| Concept             | Description                                                         |
| ------------------- | ------------------------------------------------------------------- |
| **Stack frame**     | Memory block created for each method call.                          |
| **Base condition**  | Stops recursion (prevents infinite calls).                          |
| **Stack buildup**   | Happens when calling recursively (`printNNumbers(numbers-1)`).      |
| **Stack unwinding** | Happens when returning and executing code after the recursive call. |
| **Execution order** | Inner calls finish first → outer calls resume last.                 |

printNNumbers(numbers-1);  → build-up
IO.print(numbers+" ");     → unwind
     */
    public static void printNNumbers(Integer numbers){
            if(numbers!=0){
//                IO.print(numbers+" ");
                printNNumbers(numbers-1); // build up
                IO.print(numbers+" "); //unwind result
            }
    }

    static void main() {
        PrintNNumbers.printNNumbers(5);
    }
}

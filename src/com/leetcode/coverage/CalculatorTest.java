package com.leetcode.coverage;
/*

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

*/

/*
1. INSTRUCTION
    What it means: Measures the total number of bytecode instructions executed by tests.
2. BRANCH
    What it means: Measures whether both the true and false paths of conditionals (like if or switch) were tested.
3. COMPLEXITY
    What it means: This refers to cyclomatic complexity, which counts the number of paths through the code (i.e., different logic branches).
4. LINE
    What it means: Percentage of actual lines of code that were executed during testing.
5. METHOD
    What it means: Measures how many methods in the codebase were called during testing.
6. CLASS
    What it means: Measures how many classes were touched by the tests.

🔍 Let's analyze the Calculator class and its tests:

🔍 Now, let's map this to JaCoCo Metrics:

| Metric          | Description                            | Example from Code                        x                       |
| --------------- | -------------------------------------- | --------------------------------------------------------------- |
| **Instruction** | Measures all bytecode executed         | `return a + b;` and loop iterations                             |
| **Branch**      | Checks all `if/else` or `switch` paths | `if (b == 0)` in `divide()` has 2 branches: one tested, one not |
| **Complexity**  | Cyclomatic complexity (decision paths) | `for` loop in `multiply()`, and `if` in `divide()`              |
| **Line**        | Which lines were executed              | Lines inside `add()`, `divide()`, `multiply()`                  |
| **Method**      | If the method was called at all        | `subtract()` is never tested, so not covered                    |
| **Class**       | If any method in the class was used    | Since some methods were called, class is partially covered      |


🔴 What's Missing?
The subtract() method is not tested, so:
Method Coverage is not 100%
Instruction/Line/Complexity coverage is slightly lower
The exception path in divide() (b == 0) is not tested, so:
Branch and Complexity Coverage are incomplete

 */
/*
public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3)); // Covers add()
    }

    @Test
    public void testDivide() {
        assertEquals(2, calc.divide(4, 2)); // Covers one branch (b != 0)
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(2, 3)); // Covers loop in multiply()
    }
*/

    //To improve coverage un comment the following tests
    /*
| Metric          | Description                               | **Before**                                           | **After Adding Full Tests**        |
| --------------- | ----------------------------------------- | ---------------------------------------------------- | ---------------------------------- |
| **Instruction** | Bytecode executed                         | \~70% (some logic skipped)                           | ✅ **100%** (all code paths tested) |
| **Branch**      | Conditional paths tested (if/else, etc.)  | \~50% (only one branch of `if` in `divide()` tested) | ✅ **100%** (both branches tested)  |
| **Complexity**  | Cyclomatic paths covered (loops/branches) | \~60% (missed edge cases)                            | ✅ **100%**                         |
| **Line**        | Lines of code executed                    | \~75%                                                | ✅ **100%**                         |
| **Method**      | Methods called by tests                   | \~75% (`subtract()` not tested)                      | ✅ **100%**                         |
| **Class**       | Any part of class executed in tests       | ✅ 100% (at least one method called)                 | ✅ **100%**                         |

🧪 Explanation

✅ Before Improvements:
Only tested add(), divide() (with non-zero), and multiply()

Missed:
The subtract() method → reduces Method coverage
The if (b == 0) path → reduces Branch and Complexity

✅ After Improvements:
Added test for:
subtract() → boosts Method, Instruction, and Line
Division by zero case → completes Branch and Complexity
Now all lines, branches, and methods are exercised by tests

 */

    /*@Test
    public void testSubtract() {
        assertEquals(1, calc.subtract(3, 2)); // Adds method coverage
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(4, 0)); // Completes branch
    }*/

//}

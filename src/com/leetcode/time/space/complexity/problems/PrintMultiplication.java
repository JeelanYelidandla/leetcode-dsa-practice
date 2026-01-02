

/*

Formula: Number of iterations = (last - first + 1)
for (int i = 2; i <= n; i++) ->  n - 2 + 1 = n - 1 -> O(n - 1) = O(n) : Ignore constants -1 ignored
for (int i = 1; i <= n; i++) ->  n - 1 + 1 = n - 1 -> O(n) = O(n) :No constants to ignore
for (int i = 5; i <= n; i++) ->  n - 5 + 1 = n - 4 -> O(n-4) = O(n) : Ignore constants -4 ignored

Formula: Number of iterations = (last - first )
for (int i = 2; i < n; i++) ->  n - 2 -> O(n - 2) = O(n) : Ignore constants -2 ignored
for (int i = 1; i < n; i++) ->  n - 1  -> O(n-1) = O(n-1) :Ignore constants -1 ignored
for (int i = 5; i < n; i++) ->  n - 5 ->  O(n-5) = O(n) : Ignore constants -5 ignored

for (int i = 1; i <= 5; i++) -> 5 - 1 + 1 = 5 -> O(5) = O(n) : Ignore constants
for (int i = 1; i < 5; i++)  -> 5 - 1 = 4 -> O(4) = O(n) : Ignore constants

       Time complexity: O(n)
       Space complexity: O(1): You're using the same variables i, j,
        and temporary results, so no additional space based on input size.


        | Loop Pattern               | Formula             | Example              | Iterations      |
| -------------------------- | ------------------- | -------------------- | --------------- |
| `for (i = a; i <= b; i++)` | `b - a + 1`         | `i = 1; i <= 5; i++` | `5 - 1 + 1 = 5` |
| `for (i = a; i < b; i++)`  | `b - a`             | `i = 1; i < 5; i++`  | `5 - 1 = 4`     |
| `for (i = 2; i <= n; i++)` | `n - 2 + 1 = n - 1` | `i = 2; i <= 4; i++` | `4 - 2 + 1 = 3` |

Final Tip
You don’t need to memorize special versions like n - 2 + 1 — just remember:

Inclusive (<=) → (end - start + 1)
Exclusive (<) → (end - start)

Apply these based on start, end, and the comparison operator.

=====================

for (int i = 1; i <= n; i++) {
    // constant-time work
}

formula: end-start + 1 -> n -1 + 1 = n
// Time: O(n) - loop runs n times
=============================



=====================

for (int i = 2; i <= n; i++) {
    // constant-time work
}

formula: end-start + 1 -> n -2 + 1 = n-1
// Time: O(n) - loop runs n-1 times So ignore constants. O(n).


Big-O is about how the algorithm scales. A difference of -1, +2, etc., doesn't change how fast it grows for large inputs.
So whether your loop runs:
n times
n - 1 times
or n + 2 times

→ All of these are O(n) in time complexity.

✅ Summary:
Iterations	Big-O Time Complexity
n	O(n)
n - 1	O(n)
n + 100	O(n)

✔️ So yes, you're absolutely right:

n - 1 iterations → O(n) time complexity.
=============================
    */
private static void printMultiplicationTable(int n) {

    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= 10; j++)
            System.out.println(i + " x " + j + " = " + ( i * j));
    }
    /*
        Time complexity: O(n^2)
        Space complexity: O(1) : You're using the same variables i, j,
         and temporary results, so no additional space based on input size.
     */
    System.out.println("==========================");
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            System.out.println(i + " x " + j + " = " + (i * j));
        }
    }

    /*
        Time complexity: O(n^3)
        Space complexity: O(1) : You're using the same variables i, j,
         and temporary results, so no additional space based on input size.
     */
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                System.out.println(i + " " + j + " " + k);
            }
        }
    }



}


public static void main(String[] args) {
    printMultiplicationTable(5);
}
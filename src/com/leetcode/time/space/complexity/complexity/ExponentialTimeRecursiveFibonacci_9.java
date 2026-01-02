
    /*
        // Time: O(2ⁿ) - each call makes 2 more calls
        // Space: O(n) - call stack grows linearly (max depth = n)

        ✅ O(2ⁿ) – Exponential Time (Recursive Fibonacci)
        * This code demonstrates exponential time complexity by calculating Fibonacci numbers using recursion.
        * The method `fib(int n)` calculates the nth Fibonacci number using a recursive approach.
        * The time complexity is O(2^n) because each call to `fib` results in two more calls, leading to an exponential growth in the number of calls.
        * The space complexity is O(n) due to the call stack used for recursion.
        * The method works as follows:
        * 1. If n is less than or equal to 1, it returns n (base case).
        * 2. Otherwise, it recursively calls itself for `n - 1` and `n - 2`, summing the results.

     */
    int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

    }

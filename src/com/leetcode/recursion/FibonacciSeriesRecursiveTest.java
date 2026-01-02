

    /*
 This program generates the Fibonacci series using recursion.
 f(n) = f(n-1) + f(n-2) formula is used to calculate the Fibonacci number at position n.
The base cases are f(0) = 0 and f(1) = 1


     */
    public static int fibonacciRec(int n) {
        if (n <= 1) {
            return n; // Base cases: fib(0) = 0, fib(1) = 1
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2); // Recursive call
    }

    public static void main(String[] args) {
        int count = 5; // Number of Fibonacci numbers to generate
//        for (int i = 0; i < count; i++) {
            System.out.print(fibonacciRec(5) + " ");
//        }
    }


    /*
    // Time: O(√n) - loop runs up to square root of n
    // Space: O(1) - no extra memory used
    * This code checks if a number is prime using a method that runs in O(√n) time complexity.
    *  The method `isPrime(int n)` checks if the input number `n` is prime.
    *  A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
    *  The method iterates from 2 to the square root of `n`, checking if `n` is divisible by any of these numbers.
    *  If it finds any divisor, it returns false, indicating that `n` is not prime.
    *  If no divisors are found, it returns true, indicating that `n` is prime.
    *  Time Complexity: O(√n)
    *  @param n the number to check for primality
    *  @return true if `n` is prime, false otherwise
    *  Example:
    *  Input: 29
    * Output: true (29 is a prime number)
    *  This code is a simple demonstration of checking for prime numbers in Java.
    *  It does not take any input from the user and directly checks a hardcoded number.
    * @author Jeelan Yelidandla
    * @version 1.0
     */
    private static  boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 29; // Example number to check for primality
        boolean result = isPrime(number);
        System.out.println("Is " + number + " a prime number? " + result);
    }

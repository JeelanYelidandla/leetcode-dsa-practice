/**
 * // Time: O(1) - one operation
 * // Space: O(1) - no extra memory used
 *
 * This class demonstrates constant time complexity in Java.
 * It prints the elements of an array in O(1) time complexity,
 * which means the time taken does not depend on the size of the input.
 * * The array is hardcoded, and the output is printed directly.
 * * Time Complexity: O(1)
 * * Space Complexity: O(n) for storing the array elements
 * * Example:
 * * Input: [1, 2, 3, 4, 5]
 * * * Output: 1 2 3 4 5
 * * This code is a simple demonstration of constant time complexity.
 * * It does not take any input from the user and directly prints the elements of a predefined array.
 * * @author Jeelan Yelidandla
 * * @version 1.0
 * * @since 2023-10-01
 *
 *
 *O(1) < O(log n) < O(√n) < O(n) < O(n + m) < O(n log n) < O(n²)<  O(n³) < O(2ⁿ) < O(n!)
 * * This table summarizes the time and space complexities of various algorithms:
 *
 * Time Complexity	    Example (Java)	            Time	        SpaceComplexity
 * ---------------------------------------------------------------
 * O(1)	                 Access array element	    Constant	    Constant
 * O(log n)	             Binary search	            Logarithmic	    Constant
* O(√n)	                 Prime check	            Square Root	    Constant
* O(n)	                 Sum array	                Linear	        Constant
 * O(n + m)  	        Merge arrays	            Linear	        Linear
 * O(n log n)	        Merge sort	                Log-linear	    Linear
 * O(n²)	            Print pairs	                Quadratic	    Constant
 * O(n³)	            Print triplets	            Cubic	        Constant
 * O(2ⁿ)	            Recursive Fibonacci	        Exponential	    Linear (stack)
 * O(n!)	            Permutations	            Factorial	    Linear (stack)
 * * @author Jeelan Yelidandla
 * @param args
 */
public static void main(String[] args) {
    int [] nums1 = {1, 2, 3, 4, 5};
    for (int num : nums1) {
        System.out.println(num);
    }
}

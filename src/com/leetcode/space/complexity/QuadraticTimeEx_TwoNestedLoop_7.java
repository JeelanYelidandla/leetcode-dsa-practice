
/**
 * // Time: O(n²) - two nested loops
 * // Space: O(1) - printing only, no storage
 *✅ O(n²) – Quadratic Time (Nested Loops)
 * This code demonstrates quadratic time complexity by printing all pairs of elements from an array.
 * * The time taken to execute this code increases quadratically with the size of the input array.
 * * The method `printPairs(int[] arr)` uses two nested loops to iterate through the array and print each pair of elements.
 * * * the time complexity is O(n²), where n is the number of elements in the array
 * * * The space complexity is O(1) since we are not using any additional data structures that grow with the input size.
 *
 *
 *
 * @param arr
 */
void printPairs(int[] arr) {
        for (int i : arr) {
            for (int j : arr) {
                System.out.println(i + ", " + j);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

    }


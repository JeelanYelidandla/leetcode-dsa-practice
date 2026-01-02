/**
 * Time complexity: O(n) - linear time due to single loop
 * * Space complexity: O(n) - If we used   int[] dp = new int[n + 1]; n is the input size.
 * We can reduce Space complexity to O(1) by using two variables instead of an array. or define 2 variables to store the last two results.
 * * This code calculates the number of distinct ways to climb a staircase with n steps,
 *
 * @param n
 * @return
 */
public static int climbStairs(int n) {
        // Base cases
        if (n <= 2)
            return n;  // O(1) constant time.

        // dp[i] represents number of ways to reach step i
        int[] dp = new int[n + 1]; // O(n) space complexity

        dp[1] = 1; // 1 way to climb 1 step O(1)
        dp[2] = 2; // 2 ways to climb 2 steps O(1)

        // Fill the array using the recurrence O(n) time complexity
        //Runs from i = 3 to n → That’s (n - 2) iterations → Linear time.
        //Each iteration does constant work: a single addition and assignment.
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The result is stored in dp[n]
        return dp[n];
    }

    /*
    Now:
    ✅ Time Complexity: O(n)
    ✅ Space Complexity: O(1) ← Just using 3 variables.
     */
    public static int climbStairsWithBigOConstantSpace(int n) {
    // Base cases
    if (n <= 2) return n;  // O(1) constant time.


    int a = 1; // dp[i - 2] O(1) Space complexity
    int b = 2; // dp[i - 1] O(1) Space complexity

    // Fill the array using the recurrence O(n) time complexity
    //Runs from i = 3 to n → That’s (n - 2) iterations → Linear time.
    //Each iteration does constant work: a single addition and assignment.
    for (int i = 3; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }

    // The result is stored in dp[n]
    return b;
}
    public static void main(String[] args) {
            System.out.println(climbStairs(10));
    }

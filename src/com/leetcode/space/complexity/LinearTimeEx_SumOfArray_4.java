public class LinearTimeEx_SumOfArray_4 {
    /*  // Time: O(n) - one loop through the array
        // Space: O(1) - only uses one variable
        O(n) – Linear Time (Sum of Array)
        This code demonstrates linear time complexity by calculating the sum of an array of integers.
        The time taken to execute this code increases linearly with the size of the input array.
        The method `sum(int[] arr)` iterates through each element of the array and adds it to a total sum.
        The time complexity is O(n), where n is the number of elements in the array.
        The space complexity is O(1) since we are using a fixed amount of extra space (the `total` variable).
     */
    private static int sum(int[] arr) {
        var total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
            var num = sum(new int[]{10,20,30,40,50,60,70,80,90});
            System.out.println("Sum of array: " + num);
    }
}

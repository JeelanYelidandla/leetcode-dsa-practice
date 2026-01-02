
/*
        O(n log n) – Log-linear Time (Merge Sort)
        // Time: O(n log n) - divide and conquer
        // Space: O(n) - new arrays created during merge
 * This code is an example of a log-linear time complexity algorithm, specifically
    * Merge Sort.
    * * Merge Sort is a divide-and-conquer algorithm that sorts an array by recursively
    * dividing it into halves, sorting each half, and then merging the sorted halves.
    * * The time complexity of Merge Sort is O(n log n), where n is the number of elements
    * in the array.
    * * The space complexity is O(n) due to the additional arrays created during the merge process.
    * * The method `mergeSort(int[] arr)` takes an array as input and returns a sorted array.
    * * The method works by:
    * 1. Checking if the array length is less than or equal to 1, in which case it is already sorted.
    * 2. Finding the midpoint of the array.
    * 3. Recursively calling `mergeSort` on the left and right halves of the array.
    * 4. Merging the two sorted halves using the `merge` method.
    * * Example:
 */
   private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) result[k++] = left[i++];
            else result[k++] = right[j++];
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    public static void main(String[] args) {

    }


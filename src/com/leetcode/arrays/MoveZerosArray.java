

/**
 *
 * @param arr
 * // First, move all non-zero elements forward
 * // Fill remaining positions with zeros
 *
 *  step-1 : create  index variable int type with 0
 *  step-2 : iterate array using for loop.
 *  step-3 : check if element is not zero add not zero element with newly created index. arr[index++] = num
 *  step-4: use while loop check index < arr.lenght this will give how many zero available in arr
 *  step-5 assign zero at the end of arr using arr[index++]= 0
 *
 *  Time Complexity: O(n) - we traverse linearly through the array once. O(n)+O(n) = O(2n) = O(n)
 *  Space Complexity: O(1) - we modify the array in place without using extra space = O(1)
 *
 */
    public static void moveZeroAtEndOfArray(int[] arr) {
        int index = 0; //  O(1) - index to place the next non-zero element

        // First, move all non-zero elements forward
        for (int num : arr) { // O(n)
            if (num != 0) { // O(1)
                arr[index++] = num; // O(1)
            }
        }

        // Fill remaining positions with zeros
        while (index < arr.length) { // O(n)
            arr[index++] = 0; // O(1) 
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 3, 5};
        moveZeroAtEndOfArray(arr);

        System.out.println("After moving zeros (Array): " + Arrays.toString(arr));
    }


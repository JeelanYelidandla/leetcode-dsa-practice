

    /*
    // Time: O(log n) - input size is halved each time
    // Space: O(1) - uses constant variables
    This code demonstrates a binary search algorithm in Java.
    * The method `binarySearch(int[] array, int num)` performs a
    binary search on a sorted array to find the index of a given number.
    * The time complexity is O(log n) because the search space is halved with each iteration.
    * The space complexity is O(1) since it uses a constant amount of space for variables.
    * The method returns the index of the number if found, or -1 if not found.
    * The method works as follows:
    * 1. Initialize two pointers, `left` and `right`, to the start and end of the array.
    * 2. While `left` is less than or equal to `right`, calculate the midpoint.
    * 3. If the element at the midpoint is equal to the number, return the midpoint index.
    * 4. If the element at the midpoint is less than the number, move the `left` pointer to `mid + 1`.
    * 5. If the element at the midpoint is greater than the number, move the `right` pointer to `mid - 1`.
    * 6. If the number is not found, return -1.


     */
    public static int binarySearch(int[] array,int num){
        var left = 0;
        var right = array.length - 1;
        while(left<= right){
            var mid = left + (right-left)/2;
            if(array[mid] == num){
                return mid;
            }else if(array[mid] < num){
                left = mid+1;
            }else if(array[mid] >num){
                right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{10,20,30,40,50,60,70,80,90}, 30));
    }


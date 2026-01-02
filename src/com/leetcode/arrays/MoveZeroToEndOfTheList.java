
    /*
        Step 1: Create a new list to hold non-zero elements.
        Step 2: Iterate through the original list and add non-zero elements to the new list.
        Step 3: get the element from original list.
        Step 4: check if element is not zero then add to new list.
        Step 5: subtract the size of new list from original list to get the count of zeros.
        Step 6: Iterate using for loop to add zeros at the end of new List.
     */
    public static List moveZeroAtEndOfList(List list){

        //
        var result = new ArrayList(); // O(n) - time and O(1) space
        for(int i=0; i<list.size();i++){// O(n)
          Integer number = (Integer) list.get(i); // O(1)
          if(number !=0) // O(1)
             result.add(number); // O(1)
        }

        int zeroCount = list.size()-result.size(); // O(1)
        for(int i=0; i<zeroCount; i++){ // O(n)
            result.add(0); // armortized O(1) for ArrayList otherwise O(n).
        }
        return result;
    }

    /*
        * Move all zeros in a list to the end while maintaining the order of non-zero elements.
        * Below same implementation is done in-place without using extra space.
        * * Time Complexity: O(n) - we traverse the list once to move non-zero elements and then fill the rest with zeros.
        * * Space Complexity: O(1) - we modify the list in place without using extra space.
     */
    public static void moveZeroAtEndInPlace(List<Integer> list) {
        int index = 0; // position to insert the next non-zero element

        // Step 1: Move non-zero elements to the front
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                list.set(index, list.get(i)); // overwrite
                index++;
            }
        }

        // Step 2: Fill the rest with zeros
        while (index < list.size()) {
            list.set(index, 0);
            index++;
        }

    }

    public static void main(String[] args) {
        System.out.println(moveZeroAtEndOfList(Arrays.asList(0,2,0,3,5)));
        moveZeroAtEndOfList(Arrays.asList(0,2,0,3,5));
    }

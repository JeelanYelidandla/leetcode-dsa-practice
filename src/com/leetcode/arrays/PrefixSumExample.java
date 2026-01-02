

    /**
     *
     * @param array
     *
     * step-1: Create a newArray which is length is same as input array. Copy first array in newArray with newArray[0] = array[0];
     * step-2: Iterate array using for loop array.length-1
     * step-3: Since we copied first element in newArray, we have to add sum from second position in newArray.
     *          So, newArray[i+1] = array[i]+ array[i+1]
     */
    private static void prefixSum(int[] array) {
        int[] newArray = new int[array.length];
        newArray[0] = array[0];
        for(int i = 0; i < array.length-1; i++){
            newArray[i+1] = array[i]+ array[i+1];
        }

        for(int i = 0; i < array.length; i++){
            System.out.print(newArray[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] array =  {5,10,15,20,25};
        prefixSum(array);
    }



    /**
     *
     * @param str
     * @return first letter which is having 2 letter.
     *
     *  Step 1: Create an Array List
     *  step 2: Convert String as char[] then iterate using for each loop.
     *  step 3: Check if List contains char if true return that letter, otherwise add letter in List
     *
     * Time Complexity: O(n) - where n is the length of the string, as we are iterating through each character once.
     * Space Complexity: O(n) - where n is the number of unique characters in the string, as we are storing them in a HashSet.
     * This is an efficient solution for finding the first letter that appears twice in a string.
     *
     */
    public static String firstLetterToAppearTwice(String str) {
        var list = new HashSet<String>(); // O(1) space for storing letters
        for (char ch : str.toCharArray()) { // O(n) time to iterate through characters and O(n) space for char array
            if(list.contains(String.valueOf(ch))){ // O(n) average-case lookup in HasSet and O(n^2) for ArrayList.
                return String.valueOf(ch); // Return the first letter that appears twice
            }
            list.add(String.valueOf(ch)); // O(1) average-case insertion in ArrayList
        }
        return null;
    }
    public static void main(String[] args) {
       String character = firstLetterToAppearTwice("letter");
       System.out.println(character);
    }



    /*
        Time Complexity: 2 sort: O(n log n) for str1 and O(n log n) for str2. O(n log n + n log n) = O(2n log2 n) = remove constants and coefficients = O(n log n)
        Space Complexity: O(n) for str1 and O(n) for str2. O(n + n) = O(2n) = remove constants and coefficients = O(n)
     */
    public static boolean isAnagram(String str1, String str2){

        str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase(); // O(n) Time complexity for repliaceAll and toLowerCase methods. O(n) Space complexity for storing the modified string.
        str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase(); // O(n) Time complexity for repliaceAll and toLowerCase methods. O(n) Space complexity for storing the modified string.
        if(str1.length() != str2.length()) { // O(1) Time complexity for length check. O(1) Space complexity for storing the length.
            return false; // O(1) Time complexity for returning false. O(1) Space complexity for returning false.
        }
        char charArrayStr1[] =  str1.toCharArray(); // O(n) Time complexity for toCharArray method. O(n) Space complexity for storing the character array.
        char charArrayStr2[] =  str2.toCharArray();// O(n) Time complexity for toCharArray method. O(n) Space complexity for storing the character array.
        Arrays.sort(charArrayStr1); // O(n log n) Time complexity for sorting the character array. O(n) Space complexity for sorting in place.
        Arrays.sort(charArrayStr2); // O(n log n) Time complexity for sorting the character array. O(n) Space complexity for sorting in place.
         return Arrays.equals(charArrayStr1, charArrayStr2); // O(n) Time complexity for comparing the two character arrays. O(1) Space complexity for returning the boolean result.


    }
    public static void main(String[] args) {
           System.out.println( isAnagram("anagram","nagaram"));
    }
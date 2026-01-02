
    /**
     *
     * @param s1
     * @param s2
     * @return false if both string are not anagram
     *         true if both strings are anagram
     *
     *         step -1 replaceAll special chars ^a-zA-Z with empty string with lower case.
     *         step-2  If str1 and str2 is not equal length return false its not anagram.
     *         step-3  convert both string in char[] array using str1.toCharArray()
     *         step-4 sort both char array usings Arrays.sort(charArray1) and Arrays.sort(charArray2)
     *         step-5 compare two char array using Arrays.equals(charArray1,CharArray2)
     *                  if both string are anagram it will return true otherwise false.
     *
     *   Time Complexity: 2 sort: O(n log n) for str1 and O(n log n) for str2. O(n log n + n log n) = O(2n log2 n) = remove constants and coefficients = O(n log n)
     *    Space Complexity: O(n) for str1 and O(n) for str2. O(n + n) = O(2n) = remove constants and coefficients = O(n)
    ✅ Logic Review
    | Step                           | Logic Sound? | Notes                                                        |
    | ------------------------------ | ------------ | ------------------------------------------------------------ |
    | Remove non-letters + normalize | ✅            | Good for general cases; interviewer may ask if symbols count |
    | Compare lengths early          | ✅            | Always a good optimization                                   |
    | Convert to char array & sort   | ✅            | Standard anagram approach                                    |
    | Compare sorted arrays          | ✅            | Correct and efficient for most interviews                    |

    💡 In 90% of interviews, this solution will pass. In some high-bar companies,
        they might ask for O(n) solution using a frequency map, but this is a great first response. You can say:

    “This is my clean and easy-to-read solution using sorting. If we want better time complexity,
    I can use a single-pass HashMap approach instead.”
    ✅ Time & Space Complexity (Confirmed)
    Time Complexity:
    replaceAll() → O(n)
    toLowerCase() → O(n)
    toCharArray() → O(n)
    Arrays.sort() → O(n log n)
    Arrays.equals() → O(n)
    So combined:
    ✅ O(n log n) time complexity


    Space Complexity:
    New strings created after replaceAll() and toLowerCase() → O(n)
    Character arrays → O(n)
    Sorting happens in-place (but still O(n) for array size)
    ✅ O(n) space complexity
    ✅ You’re right about removing constants like 2n or 2n log n — your simplification was accurate.


    BELOW ONE IS important for interviews:

    ✨ Bonus Tip (Behavior During Interviews)
    If you're asked this:
    🧑‍💼 “Can you solve this without sorting?”

    “Yes. I can use a HashMap to count character frequency of str1, then decrement while scanning str2. If any char is missing or count goes negative, return false. It’s O(n) time, O(1) space (since alphabet size is fixed).”

    That shows you're aware of trade-offs — this builds trust.
     */
    public static boolean isAnagram(String s1, String s2){
        s1 = s1.replaceAll("[^a-zA-Z]", "").toLowerCase(); // O(n) Time complexity for replaceAll and toLowerCase methods. O(n) Space complexity for storing the modified string.
        s2 = s2.replaceAll("[^a-zA-Z]", "").toLowerCase();// O(n) Time complexity for replaceAll and toLowerCase methods. O(n) Space complexity for storing the modified string.

        if(s1.length() != s2.length()){// O(1) Time complexity for length check. O(1) Space complexity for storing the length.
            return false; // O(1) Time complexity for returning false. O(1) Space complexity for returning false.
        }

        char[]  s1CharArray=  s1.toCharArray();// O(n) Time complexity for toCharArray method. O(n) Space complexity for storing the character array.
        char[]  s2CharArray=  s2.toCharArray();// O(n) Time complexity for toCharArray method. O(n) Space complexity for storing the character array.
        Arrays.sort(s1CharArray);// O(n log n) Time complexity for sorting the character array. O(n) Space complexity for sorting in place.
        Arrays.sort(s2CharArray);// O(n log n) Time complexity for sorting the character array. O(n) Space complexity for sorting in place.

        return Arrays.equals(s1CharArray,s2CharArray);// O(n) Time complexity for comparing the two character arrays. O(1) Space complexity for returning the boolean result.


    }
    void main(String[] args) {
       System.out.println(isAnagram("r@a ce9", "9ca#r e"));
       System.out.println(isAnagram("race", "card"));
    }


/**
 *
 * @param s input String
 * @param t input String
 * @return true if String s chars available in same order in t string.
 * for ex:
 *  s = "ace" t = "abcde" ->✅ Valid subsequence
 * s = "ace" t = "bcade" -> ⛔ Invalid subsequence
 * s = "ace" t = "ecadb" -> ⛔ Invalid subsequence
 *
 *  ALGO START TWO POINTER APPROACH
 *  -----------
 *  create i, j variable initialize with zero.
 *  use while loop  check i<s.length() && t.length()<t
 *  check if s.chartAt(i) == t.chartAt(j) is true then increment i value and j value.  otherwise increment only j value.
 *  once while loop iteration finished. check i == s.lenght() if both same return true otherwise false.
 *
 *  ALGO END
 *
 * | i (s) | j (t) | s.charAt(i) | t.charAt(j) | Match? | i++ | j++ |
 * | ----- | ----- | ----------- | ----------- | ------ | --- | --- |
 * | 0     | 0     | `'a'`       | `'a'`       | ✅      | 1   | 1   |
 * | 1     | 1     | `'c'`       | `'b'`       | ❌      | -   | 2   |
 * | 1     | 2     | `'c'`       | `'c'`       | ✅      | 2   | 3   |
 * | 2     | 3     | `'e'`       | `'d'`       | ❌      | -   | 4   |
 * | 2     | 4     | `'e'`       | `'e'`       | ✅      | 3   | 5   |
 */


    public static boolean isSubsequence(String s, String t) {

        var i=0;
        var j=0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    public static void main(String[] args) {
        System.out.println( isSubsequence("ace", "bcade"));
    }


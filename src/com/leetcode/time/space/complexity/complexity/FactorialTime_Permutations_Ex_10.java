/**
 * // Call with: permute("ABC", "")
 * // Time: O(n!) - all permutations of length n
 * // Space: O(n) - call stack depth + temporary strings
 *
 *
 * @param str
 * @param ans
 */
private static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, ans + ch);
        }
    }

// Call with: permute("ABC", "")

public static void main(String[] args) {

    }
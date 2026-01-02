
    public static void main(String[] args) {
        String input = "madam";

        if (isPalindrome(input)) {
            System.out.println("Palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }
    }

    /**
     *  step 1: create two int left =0  and right= lenght-1 variables.
     *  Step 2: iterate using while (left < right)
     *  Step 3: check if charAt(left) != chartAt(right) return false if not equal. means its not palindrom
     *  Step 4: if equal then increase left++ and right -- till end of the iteration. Finally return true.
     *
     *
     * @param str
     * @return
     */

    /*
Time Complexity: O(n)
    Where n is the length of the string
    In the worst case, the while loop runs through half the string (n/2 iterations)
    Since we drop constants in Big O notation, this simplifies to O(n)

Space Complexity: O(1)
    Only using a fixed number of variables (left, right)
    No additional data structures that grow with input size
    The input string itself is not counted in auxiliary space complexity

Why O(n) time?
Best case: O(1) - if first and last characters don't matc
Average/Worst case: O(n) - need to compare characters until pointers meet

 */
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


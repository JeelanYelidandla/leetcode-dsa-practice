
    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        var left = 0;
        var right = chars.length - 1;

        while (left < right) {
            // Move left pointer to the next vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            // Move right pointer to the previous vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            // Swap the vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));  // Output: AceCreIm
        System.out.println(reverseVowels("leetcode"));  // Output: leotcede
    }


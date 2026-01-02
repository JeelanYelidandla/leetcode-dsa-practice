

    public static void main(String[] args) {
        String str = "my name is xyz";
        System.out.println("Largest substring without repeating characters: " + findLargestSubstring(str));
    }

    public static String findLargestSubstring(String str) {
        int n = str.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        int start = 0;

        // Using a regular for-loop instead of IntStream to avoid lambda issues
        for (int right = 0; right < n; right++) {
            // If character is already in the set, move the left pointer
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(str.charAt(right));

            // Update maxLength and start if we found a larger substring
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;

                start = left;
            }
        }

        // Return the largest substring without repeating characters
        return str.substring(start, start + maxLength);
    }


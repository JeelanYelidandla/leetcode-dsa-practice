    /*
        * Find the first non-repeated character in a string.
        * time complexity O(n) and space complexity O(n)
     */
    public static int findNonRepeatedChar(String str) {
        var map = new LinkedHashMap<Character, Integer>(); // time complexity O(1) and Space complexity O(1)
        char[] charArray =   str.toCharArray(); // time complexity O(n) and space complexity O(n)
        if(str != null && !str.isEmpty()) { // time complexity O(1) and space complexity O(1)
             for (char c : charArray){ // time complexity O(n) and space complexity O(1)
                 map.put(c, map.getOrDefault(c,0)+1); // time complexity O(1) and space complexity O(1)
             }
        }

        for(int i =0 ; i< str.length() ; i++){ // time complexity O(n) and space complexity O(1)
            char c = str.charAt(i); // time complexity O(1) and space complexity O(1)
            if(map.get(c)==1){ // time complexity O(1) and space complexity O(1)
                return i; // time complexity O(1) and space complexity O(1)
            }
        }


        return -1; // Return -1 if no non-repeated character is found
    }
    public static void main(String[] args) {
            System.out.println(findNonRepeatedChar("acbab"));
    }


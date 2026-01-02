

    /*

| Line/Operation                                                             | Time Complexity | Space Complexity         | Explanation                                                  |
| -------------------------------------------------------------------------- | --------------- | ------------------------ | ------------------------------------------------------------ |
| `var charSet = new LinkedHashSet<>();`                                     | O(1)            | O(1)                     | Initializes empty set (no elements yet)                      |
| `for (int i = 0; i < str.length(); i++)`                                   | O(n)            | O(1)                     | Loop runs once for each character in the string              |
| `var c = str.charAt(i);`                                                   | O(1)            | O(1)                     | Accesses character at index `i`, no new memory               |
| `charSet.add(c);`                                                          | O(1) avg        | O(1) per op → O(k) total | Adds character to set; space grows with unique chars (k ≤ n) |
| `var deduplicatedString = new StringBuilder();`                            | O(1)            | O(1)                     | Creates empty builder                                        |
| `for (var c : charSet)`                                                    | O(k) ≤ O(n)     | O(1)                     | Iterates through set of unique characters                    |
| `deduplicatedString.append(c);`                                            | O(1) amortized  | O(1) per op → O(k) total | Appends each unique char; builder grows in size              |
| `System.out.println("The deduplicated string is: " + deduplicatedString);` | O(k)            | O(1)                     | Printing string of size `k`; linear in size                  |


https://chatgpt.com/share/688bb054-f540-8001-8f22-dceb8b85ce0b

     * @param str
     * step 1: create LinkedHashSet
     * step 2: use for loop str.length(),
     * step 3: use charAt(i) method to get each character add it to LinkedHashSet. Since HashSet will remove duplicates.
     *          it will not allow duplicates.
     * step 4: Create string builder, then iterate LinkedHashSet useing forEach append each char to StringBuilder.
     *
✅ Final Summary Table

 | Metric               | Value | Explanation                                            |
| -------------------- | ----- | ------------------------------------------------------ |
| **Time Complexity**  | O(n)  | One pass to build set, one pass to append unique chars |
| **Space Complexity** | O(n)  | Set + StringBuilder store up to `n` unique characters  |

     */
    public static void removeDuplicateChar(String str){
        var charSet = new LinkedHashSet<>(); // Time Complexity O(1) and Space Complexity O(1)
        for (int i = 0; i < str.length(); i++) { // Time Complexity O(n) and Space Complexity O(1)
            var c = str.charAt(i); // O(1) time and Space Complexity O(1)
            charSet.add(c); // O(1) time and Space Complexity O(1)
        }
        var deduplicatedString = new StringBuilder(); // O(1) time and Space Complexity O(1)
        for (var c : charSet) { // O(n) time and Space Complexity O(1)
            deduplicatedString.append(c); //  O(n) time and Space Complexity O(n)
        }
        System.out.println("The deduplicated string is: " + deduplicatedString);
    }
    public static void main(String[] args) {
        removeDuplicateChar("qqqppppaabbddccffzzyy");
    }


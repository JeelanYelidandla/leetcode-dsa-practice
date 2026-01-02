
/*

🧮 Time & Space Complexity Table

| Line/Operation                                   | Time Complexity  | Space Complexity | Explanation                                                                  |
| ------------------------------------------------ | ---------------- | ---------------- | ---------------------------------------------------------------------------- |
| `str.trim()`                                     | O(n)             | O(n)             | Creates a new trimmed string (copy of `str` without leading/trailing spaces) |
| `.split("\\s+")`                                 | O(n)             | O(n)             | Splits string into words (max n words); allocates array of substrings        |
| `new StringBuilder()`                            | O(1)             | O(1)             | Initial object creation                                                      |
| `for (int i = splitStr.length - 1; i >= 0; i--)` | O(n)             | O(1)             | Loop runs once per word                                                      |
| `stringBuilder.append(splitStr[i])`              | O(1) (amortized) | O(1) per append  | Appends word to StringBuilder                                                |
| `stringBuilder.append(" ")`                      | O(1)             | O(1)             | Appends space if not last word                                               |
| `return stringBuilder.toString()`                | O(n)             | O(n)             | Converts StringBuilder content into final string                             |

✅ Final Summary

| Metric    | Complexity | Reason                                                             |
| --------- | ---------- | ------------------------------------------------------------------ |
| **Time**  | O(n)       | Trim + split + loop + append all operate linearly in input size    |
| **Space** | O(n)       | New array from split and final result string need additional space |



🧪 Scenario: Building "Hello!" using StringBuilder

We’ll append 6 characters one by one:

StringBuilder sb = new StringBuilder();
sb.append('H');
sb.append('e');
sb.append('l');
sb.append('l');
sb.append('o');
sb.append('!');

📊 Internal Growth Table

| Append #  | Char | Current Size | Capacity Before | Resize Action | Copy Cost | Total Cost |
| --------- | ---- | ------------ | --------------- | ------------- | --------- | ---------- |
| 1         | 'H'  | 1            | 1 (OK)          | No            | 0         | 1          |
| 2         | 'e'  | 2            | 1 (full)        | Resize 1 → 2  | 1         | 2          |
| 3         | 'l'  | 3            | 2 (full)        | Resize 2 → 4  | 2         | 3          |
| 4         | 'l'  | 4            | 4 (OK)          | No            | 0         | 1          |
| 5         | 'o'  | 5            | 4 (full)        | Resize 4 → 8  | 4         | 5          |
| 6         | '!'  | 6            | 8 (OK)          | No            | 0         | 1          |
| **Total** |      |              |                 |               | **7**     | **13**     |



✅ Final Summary

| Metric    | Complexity | Reason                                                             |
| --------- | ---------- | ------------------------------------------------------------------ |
| **Time**  | O(n)       | Trim + split + loop + append all operate linearly in input size    |
| **Space** | O(n)       | New array from split and final result string need additional space |

 */
    public static String reversWordInString(String str){
        //splitStr contains 2 elements in array. first Hello second element World
        String[] splitStr =  str.trim().split("\\s+"); //O(n) time complexity and O(n) space complexity
          StringBuilder stringBuilder = new StringBuilder();// O(1) space and O(1) time complexity

          for (int i = splitStr.length-1 ; i >= 0; i--){ // O(n) time complexity
                stringBuilder.append(splitStr[i] ); // O(1) space complexity for each append
                if(i != 0){ // O(1)
                    stringBuilder.append(" ");// O(1) space complexity for each append
                }
          }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(reversWordInString("Hello World"));
        System.out.println(reversWordInString("the sky is blue"));
        System.out.println(reversWordInString("a good   example"));

    }


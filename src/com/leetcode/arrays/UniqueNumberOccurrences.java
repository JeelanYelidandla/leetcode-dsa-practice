

    /*

✅ Updated Table with Time and Space Complexity

| Line/Operation                               | Time Complexity         | Space Complexity | Explanation                                                          |
| -------------------------------------------- | ----------------------- | ---------------- | -------------------------------------------------------------------- |
| `var map = new HashMap<Integer, Integer>();` | O(1)                    | O(1)             | Initializing the map takes constant time and space                   |
| `for (int i : arr)`                          | O(n)                    | O(1)             | Loop runs once per element in `arr`, no extra space used here        |
| `map.put(i, map.getOrDefault(i, 0) + 1);`    | O(1) per op, O(n) total | O(n)             | Average-case O(1) insertion and lookup; map stores up to `n` entries |
| `var set = new HashSet<Integer>();`          | O(1)                    | O(1)             | Initializing a set is constant time and space                        |
| `for (var count : map.values())`             | O(k), where k ≤ n       | O(1)             | Iterates over unique keys’ counts only (k unique elements max)       |
| `if (!set.add(count))`                       | O(1) per op, O(k) total | O(k)             | Inserting up to `k` counts into the set; O(1) per insert             |
| `return true / false`                        | O(1)                    | O(1)             | Simple return statement takes constant time and no extra space       |

counting frequency of elements in an array: Takes O(n) time where n is the size of the array.
checking if all frequencies are unique: Takes O(n) time where n is the number of unique elements in the array.
Overall time complexity: O(n) + O(n) = O(n)

You're 100% correct in logic: O(n) + O(n) = O(2n)
But in Big-O notation, we drop constant factors, so:
Time Complexity: O(n)

Space Complexity
freqMap: Stores up to n key-value pairs → O(n)
freqSet: Also up to n frequencies → O(n)
👉 Total Space Complexity: O(n)

✅ Final Summary:
| Metric    | Complexity | Reasoning                                                        |
| --------- | ---------- | ---------------------------------------------------------------- |
| **Time**  | O(n)       | 1 pass through array + 1 pass through map of size ≤ n            |
| **Space** | O(n)       | HashMap + HashSet can each hold up to `n` elements in worst case |


     */
    private static boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();//O(1) space to initialize. O(1) for time complexity
        for (int i : arr){ //O(n) time complexity , O(1) space to initialize
            // Count occurrences of each number
           map.put(i, map.getOrDefault(i, 0) + 1); // O(1)
        }
        var set = new HashSet<Integer>(); // O(1) space to initialize. O(1) for time complexity
        for(var count : map.values()){ // O(n) time complexity, O(1) space to initialize
            if(!set.add(count)){ // O(1) average-case insertion
                return false; // If the count already exists in the set, return false
            }
        }
        return true;
    }
    public static void main(String[] args) {
       int[] arr = {1,2,2,1,1,3,3,3,3};
       System.out.println(uniqueOccurrences(arr));
    }
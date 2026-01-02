
        /*
           Time Complexity: O(n)
           - We iterate through the array once => O(n)
           - HashSet operations (contains, add) are O(1) on average
           => Total time = O(n)

           Space Complexity: O(n)
           - In the worst case (no duplicates), we store all elements in the HashSet
           => Total space = O(n)

        | Line                        | Space Complexity (Per Operation) | Contributes to Total Space? |
        | --------------------------- | -------------------------------- | --------------------------- |
        | `new HashSet<>()`           | O(1)                             | ❌ (just initialization)     |
        | `set.add(num)`              | O(1)                             | ✅ (adds to memory usage)    |
        | Entire `HashSet` after loop | —                                | ✅ `O(n)` in worst case      |

        */
    public static boolean hasDuplicate(int[] nums) {
        var set = new HashSet<Integer>(); // O(1) space to initialize
        // O(n) loop over n elements
        for(int num : nums) {
            if(set.contains(num)) { // O(1) average-case lookup
                return true; // Duplicate found
            }
            set.add(num); // O(1) average-case insertion. worse case if element not found in set O(n) space complexity.
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4};
        System.out.println(hasDuplicate(nums));
    }


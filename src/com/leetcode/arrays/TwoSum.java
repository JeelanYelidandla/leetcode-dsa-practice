

    // Function to find two indices whose values add up to the target
    /**
     *
     * @param nums
     * @param target
     * @return return int array with index which is sum of target array
     *
     *  step-1 Create hashmap
     *  step-2 Iterate using for loop nums.length()
     *  step-3 Get each element in loop int num =nums[i] then identify complement using int complement = target-num;
     *  step-4 Check map if key, value exist in map for given complement key.
     *          Return int[] new int[] { map.get(complement), i } if complement found.
     *  step-6 If not store present num and loop index  map.put(num, i);
     *
     *  | Line/Operation                          | Complexity | Explanation                             |
     * | --------------------------------------- | ---------- | --------------------------------------- |
     * | `HashMap<Integer, Integer> map = ...`   | O(1)       | Init is constant time                   |
     * | `for (int i = 0; i < nums.length; i++)` | O(n)       | Loop runs once per element              |
     * | `int num = nums[i];`                    | O(1)       | Constant time read                      |
     * | `int complement = target - num;`        | O(1)       | Simple arithmetic                       |
     * | `map.containsKey(complement)`           | O(1)       | Average-case HashMap lookup             |
     * | `map.put(num, i);`                      | O(1)       | Average-case insert in HashMap          |
     * | **Total Time:**                         | **O(n)**   | Each operation is O(1) inside O(n) loop |
     *
     * O(1) + O(n) + O(1) + O(1) + O(1) + O(1) = O(n)+ O(5) = O(n) (Removed constants)
     *
     *✅ Summary
     *
     * | Metric    | Complexity | Why                                                             |
     * | --------- | ---------- | --------------------------------------------------------------- |
     * | **Time**  | **O(n)**   | Each number is visited once, each operation inside loop is O(1) |
     * | **Space** | **O(n)**   | In worst case, we store all elements in the HashMap             |
     *
     * In interviews, add 1–2 lines like:
     * "I chose HashMap because it lets me look up complements in constant time. The first time I see a number,
     * I store it. If I see its complement later, I return the indices. It avoids nested loops and ensures linear time."
     * This shows not just what you did, but why — that’s the architect-level thinking companies love.
     */
    public static int[] twoSum(int[] nums, int target) {
        // Map to store (key=nums[i] and value -> index = i)
        // map.put(nums[i], i); Means key=2 and value 0
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
            int complement = target -  nums[i];
            // If complement is found, return both indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current number and its index
            map.put(nums[i], i);
        }
        // If no result found (though the problem guarantees one), return empty
        return new int[] {};
    }
    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        // Output the result
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }


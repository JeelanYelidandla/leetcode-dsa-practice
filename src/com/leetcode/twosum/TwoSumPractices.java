

    public static boolean twoSum(int arr[], int target){
        // Create a HashSet to store the elements
        var set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (set.contains(complement)) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static int [] twoSumWithIntArray(int arr[], int target){
        // Create a HashSet to store the elements
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr){
            int complement = target - i;
            if (set.contains(complement)) {
                return new int[]{complement, i}; // If found, return the pair
            }
            // Add the current element to the set
            set.add(i);
        }
        // If no pair is found
        return new int[]{};
    }

    /*
        * Function to find two indices whose values add up to the target using HashMap
        * Time Complexity: O(n) - Each element is processed once
        * Space Complexity: O(n) - HashMap stores up to n elements in the worst
     */
    public static int[] toSumWithMap(int arr[], int target) {
        // Create a HashMap to store the elements and their
        var hashmap = new HashMap<Integer, Integer>(); //O(1) space to initialize. O(1) for time complexity
        for (int i = 0; i < arr.length; i++) { // O(n) time complexity, O(1) space to initialize
            int complement = target - arr[i]; // O(1) time complexity, O(1) space to initialize
            if(hashmap.containsKey(complement)) { // O(1) average-case lookup in HashMap
                return new int[]{hashmap.get(complement), i}; // O(1) time complexity, O(1) space to initialize
            }
            // Add the current element to the map
            hashmap.put(arr[i],i); // O(1) time complexity, O(1) space complexity O(n) worse case space complexity.
        }
        return new int[]{}; // O(1) time complexity, O(1) space to initialize
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int result[] = toSumWithMap(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
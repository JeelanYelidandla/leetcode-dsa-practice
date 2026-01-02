
    /*
        Majority Element
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than n/2 times.
     * You may assume that the majority element always exists in the array.
     *
     * Time Complexity: O(n) - linear time to traverse the array
     * Space Complexity: O(1) - constant space for count and candidate
     *
     * Example:
     * Input: [1,4,4,4,4,4,2,3,1,4,2,4,3,2]
     * Output: 4

     *Input: [2, 2, 1, 1, 1, 2, 2]
     *
| Step | num | candidate | count | Action                          |
| ---- | --- | --------- | ----- | ------------------------------- |
| 1    | 2   | 2         | 1     | count was 0, set candidate to 2 |
| 2    | 2   | 2         | 2     | match → increment count         |
| 3    | 1   | 2         | 1     | not match → decrement           |
| 4    | 1   | 2         | 0     | not match → decrement           |
| 5    | 1   | 1         | 1     | count=0 → set candidate to 1    |
| 6    | 2   | 1         | 0     | not match → decrement           |
| 7    | 2   | 2         | 1     | count=0 → set candidate to 2    |

* ✅ Final candidate: 2, which is the majority (appears 4 times out of 7)
     * Approach: Boyer-Moore Voting Algorithm
     *
     * step-1 Initialize count=0 and candidate=0.
     * step-2 User for loop to iterate through each number in the array.
     * step-3 If count is 0, set the candidate = num.
     * step-4 Check if num is equal to candidate. If true increment count by 1.
     *              else decrement count by 1.
     * step-5 After the loop ends, candidate will be the majority element. return candidate.
     */
    public static int majorityElement(int[] nums) {
        int count = 0;             // count of the current candidate O(1) space complexity
        int candidate = 0;         // potential majority element O(1) space complexity

        for (int num : nums) { // iterate through each number O(n) time complexity
            if (count == 0) { // O(1)
                candidate = num;   // set new candidate when count is 0 O(1) space complexity
            }

            // vote: +1 if same as candidate, else -1
            if (num == candidate) { // O(1) time complexity
                count++;           // increment count if num is the candidate O(1) space complexity
            } else {
                count--; // decrement count if num is different O(1) space complexity
            }
        }

        return candidate;          // candidate is guaranteed to be the majority element
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{4,4,4,1,2,4,4,2,2,1}));
    }

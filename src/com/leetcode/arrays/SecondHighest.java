
    public static int findSecondHighest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num != highest) {
                secondHighest = num;
            }
        }

        if (secondHighest == Integer.MIN_VALUE) {
            throw new RuntimeException("No second highest element found (may be all duplicates)");
        }
        return secondHighest;
    }
    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 7, 19, 19};
        int result = findSecondHighest(arr);
        System.out.println("Second highest number is: " + result);
    }


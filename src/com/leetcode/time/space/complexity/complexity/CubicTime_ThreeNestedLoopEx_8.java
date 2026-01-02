    /**
     *
     * // Time: O(n³) - three nested loops
     * // Space: O(1) - printing only, no storage
     * @param arr
     */
    public static void printTriplets(int[] arr) {
        for (int i : arr) {
            for (int j : arr) {
                for (int k : arr) {
                    System.out.println(i + ", " + j + ", " + k);
                }
            }
        }
    }
    public static void main(String[] args) {

    }
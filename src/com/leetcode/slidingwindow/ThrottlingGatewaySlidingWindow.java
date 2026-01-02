package com.leetcode.slidingwindow;

public class ThrottlingGatewaySlidingWindow {

    public static int droppedRequests(int[] requestTime) {
        int n = requestTime.length;
        int dropped = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            // Rule 1: No more than 3 requests per second
            int countSameSecond = 0;
            for (int k = right; k >= 0 && requestTime[k] == requestTime[right]; k--) {
                countSameSecond++;
            }
            if (countSameSecond > 3) {
                dropped++;
                continue;
            }

            // Rule 2: No more than 20 requests in 10 seconds
            while (right - left >= 20 && requestTime[right] - requestTime[left] >= 10) {
                left++;
            }
            if (right - left + 1 > 20) {
                dropped++;
                continue;
            }

            // Rule 3: No more than 60 requests in 60 seconds
            while (right - left >= 60 && requestTime[right] - requestTime[left] >= 60) {
                left++;
            }
            if (right - left + 1 > 60) {
                dropped++;
            }
        }

        return dropped;
    }

    public static void main(String[] args) {
        int[] requestTime = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11};
        int result = droppedRequests(requestTime);
        System.out.println("Total dropped requests (Sliding Window): " + result);
    }
}

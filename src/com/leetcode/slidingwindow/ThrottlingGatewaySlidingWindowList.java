package com.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ThrottlingGatewaySlidingWindowList {

    public static int droppedRequests(List<Integer> requestTime) {
        int n = requestTime.size();
        int dropped = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            // Rule 1: No more than 3 requests per second
            int countSameSecond = 0;
            for (int k = right; k >= 0 && Objects.equals(requestTime.get(k), requestTime.get(right)); k--) {
                countSameSecond++;
            }
            if (countSameSecond > 3) {
                dropped++;
                continue;
            }

            // Rule 2: No more than 20 requests in 10 seconds
            while (right - left >= 20 && requestTime.get(right) - requestTime.get(left) >= 10) {
                left++;
            }
            if (right - left + 1 > 20) {
                dropped++;
                continue;
            }

            // Rule 3: No more than 60 requests in 60 seconds
            while (right - left >= 60 && requestTime.get(right) - requestTime.get(left) >= 60) {
                left++;
            }
            if (right - left + 1 > 60) {
                dropped++;
            }
        }

        return dropped;
    }

    public static void main(String[] args) {
        List<Integer> requestTime = Arrays.asList(
                1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11
        );
        int result = droppedRequests(requestTime);
        System.out.println("Total dropped requests (Sliding Window using List): " + result);
    }
}

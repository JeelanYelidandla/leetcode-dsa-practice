package com.leetcode.slidingwindow;

import java.util.*;

public class ThrottlingGatewayOptimizedList {

    public static int droppedRequests(List<Integer> requestTime) {
        int n = requestTime.size();
        int dropped = 0;

        for (int i = 0; i < n; i++) {
            int current = requestTime.get(i);
            System.out.println("CURRENT: "+current + " I Value " + i);
            // Rule 1: More than 3 per second
            if (i >= 3 && Objects.equals(current, requestTime.get(i - 3))) {
                System.out.println("More than 3 per req"+requestTime.get(i - 3));
                dropped++;
            }

            // Rule 2: More than 20 requests in 10 seconds
            else if (i >= 20 && current - requestTime.get(i - 20) < 10) {
                dropped++;
            }

            // Rule 3: More than 60 requests in 60 seconds
            else if (i >= 60 && current - requestTime.get(i - 60) < 60) {
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
        System.out.println("Total dropped requests (Optimized using List): " + result);
    }
}

package com.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest element is: " + findKthLargest(nums, k));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(3);
        pq.add(10);
        pq.add(1);

        System.out.println(pq.peek()); // Output: 1 (smallest element)

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(10);
        maxHeap.add(1);

        System.out.println(maxHeap.peek()); // Output: 10 (largest element)


    }
}

package com.leetcode.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElementWithEntrySet {
    // Return top k elements with their frequency
    public static PriorityQueue<Map.Entry<Integer, Integer>> findTopElement(int[] array, int k) {
        // Step 1: Count frequencies
        var map = new HashMap<Integer, Integer>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> minHeapWithInteger =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        // Step 3: Push entries into minHeap
        for (var entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap; // Contains top k entries (key + frequency)
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3};
        PriorityQueue<Map.Entry<Integer, Integer>> topK = findTopElement(array, 2);

        // Print result
        while (!topK.isEmpty()) {
            Map.Entry<Integer, Integer> entry = topK.poll();
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }
}

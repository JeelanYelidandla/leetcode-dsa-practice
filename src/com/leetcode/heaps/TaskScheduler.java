package com.leetcode.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char t : tasks)
            freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());

        Queue<int[]> queue = new LinkedList<>(); // {count, readyTime}
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    queue.offer(new int[]{count, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Minimum intervals required: " + leastInterval(tasks, n));
    }
}

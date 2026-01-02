package com.leetcode.heaps;

import java.util.*;

public class TopKElementFindWithList {


/*
 Time Complexity: O(n log k)
   - Building frequency map: O(n)
   - Maintaining min-heap of size k: O(n log k)

 Space Complexity: O(n + k)
   - HashMap stores up to n unique elements
   - PriorityQueue stores up to k elements
   - Overall: O(n) in worst case

   ✅ Final Answer for Your Code:
Time Complexity: O(n log k)
Space Complexity: O(n) (since O(n + k) simplifies to O(n))
*/

    public static List<Integer> findTopElement(int [] array, int k){
        var map = new HashMap<Integer,Integer>();
        for (int num: array){
               map.put(num, map.getOrDefault(num,0)+1);
        }
        var minHeapPriorityQueue = new PriorityQueue<Map.Entry<Integer,Integer>>((a,b)-> a.getValue() - b.getValue());
        for(var entry : map.entrySet()){
            minHeapPriorityQueue.add(entry);
            if(minHeapPriorityQueue.size()>k){
                minHeapPriorityQueue.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeapPriorityQueue.isEmpty()) {
            result.add(minHeapPriorityQueue.poll().getKey());
        }
        Collections.reverse(result); // optional, to return highest frequency first
        return result; // Contains top k entries (key + frequency)
    }
    static void main() {
        int array[] = new int[] {1,1,1,2,2,3};
        List<Integer> result = TopKElementFindWithList.findTopElement(new int[] {1,1,1,2,2,3,3,3,3,3},2);
        System.out.println(result);
    }
}

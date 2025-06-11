package com.kunal.Dsa.HeapsandHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentHashHeap {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for (int num:nums) {
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for (Map.Entry<Integer,Integer>entry :freqMap.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int [] result = new int[k];
        int i=0;
        while (!minHeap.isEmpty()){
            result[i++]=minHeap.poll().getKey();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        // Output: [1, 2]
    }
}

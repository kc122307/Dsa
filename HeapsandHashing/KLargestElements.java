package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {
    public static List<Integer> findKLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num:arr) {
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(minHeap);
        result.sort(Collections.reverseOrder());
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        System.out.println("K Largest Elements: " + findKLargest(arr, k));
    }
}

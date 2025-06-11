package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInStream {
    public static List<Integer> kthLargest(int[] arr, int k) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       List<Integer> result = new ArrayList<>();

        for (int num:arr) {
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
            if(minHeap.size()<k){
                result.add(-1);
            }
            else {
                result.add(minHeap.peek());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int k1 = 4;
        System.out.println(kthLargest(arr1, k1)); // Output: [-1, -1, -1, 1, 2, 3]

        int[] arr2 = {10, 20, 5, 15};
        int k2 = 2;
        System.out.println(kthLargest(arr2, k2)); // Output: [-1, 10, 10, 15]

        int[] arr3 = {3, 4};
        int k3 = 1;
        System.out.println(kthLargest(arr3, k3)); // Output: [3, 4]
    }
}

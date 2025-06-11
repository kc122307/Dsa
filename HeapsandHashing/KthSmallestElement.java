package com.kunal.Dsa.HeapsandHashing;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int findKthSmallest(int[] arr, int k) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num:arr) {
            minHeap.offer(num);
        }
        for (int i = 1; i <k ; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Kth smallest element is: " + findKthSmallest(arr1, k1)); // 7

        int k2 = 4;
        System.out.println("Kth smallest element is: " + findKthSmallest(arr1, k2)); // 10
    }
}

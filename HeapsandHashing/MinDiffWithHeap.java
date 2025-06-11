package com.kunal.Dsa.HeapsandHashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinDiffWithHeap {
    public static int findMinDiffHeap(int[] arr, int m) {
      int n = arr.length;
      Arrays.sort(arr);
      int mindiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n-m; i++) {
            PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minheap = new PriorityQueue<>();

            for (int j = 0; j <i+m; j++) {
                maxheap.offer(arr[j]);
                minheap.offer(arr[j]);
            }

            int diff = maxheap.peek()-minheap.peek();
            mindiff=Math.min(diff,mindiff);
        }
        return mindiff;
    }
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println("Minimum difference is " + findMinDiffHeap(arr, m)); // Output: 2
    }
}

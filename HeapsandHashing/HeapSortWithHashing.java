package com.kunal.Dsa.HeapsandHashing;

import java.util.*;

public class HeapSortWithHashing {
    public static int[] sortWithHeapAndHash(int[] arr) {
        int n= arr.length;

        HashMap<Integer,List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            indexMap.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num:arr) {
            maxHeap.add(num);
        }
        int [] sorted = new int[n];
        int i=0;
        while(!maxHeap.isEmpty()){
            int val = maxHeap.poll();
            sorted[i++]=val;
            System.out.println("Original indices of " + val + " -> " + indexMap.get(val));
        }
        return sorted;
    }
    public static void main(String[] args) {
        int[] arr = {4, 10, 4, 3, 5, 1};
        int[] sorted = sortWithHeapAndHash(arr);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
    }
}

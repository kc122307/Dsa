package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestKUsingHeap {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
           int diff1 =Math.abs(x-a);
           int diff2 = Math.abs(x-b);
           if(diff1==diff2) return b-a;
           return diff2-diff1;
       });

        for (int num:arr) {
            if(num==x) continue;
            maxHeap.offer(num);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k1 = 4, x1 = 35;
        System.out.println(findClosestElements(arr1, k1, x1)); // Output: [30, 39, 42, 45]

        int[] arr2 = {1, 3, 4, 10, 12};
        int k2 = 2, x2 = 4;
        System.out.println(findClosestElements(arr2, k2, x2)); // Output: [1, 3]
    }
}

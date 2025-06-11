package com.kunal.Dsa.HeapsandHashing;

import java.util.HashSet;
import java.util.Set;

public class KthSmallestAfterRemoving {
    public static int findKthSmallest(int[] arr, int k) {
       Set<Integer> removed = new HashSet<>();

        for (int num:arr) {
            removed.add(num);
        }

        int count=0;
        int current =1;
        while(count<k){
            if(!removed.contains(current)){
                count++;
                if(count==k) return current;
            }
            current++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr1 = {1};
        int k1 = 1;
        System.out.println("Output: " + findKthSmallest(arr1, k1));  // Output: 2

        int[] arr2 = {1, 3};
        int k2 = 4;
        System.out.println("Output: " + findKthSmallest(arr2, k2));  // Output: 6
    }
}

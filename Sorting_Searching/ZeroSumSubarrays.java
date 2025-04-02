package com.kunal.Dsa.Sorting_Searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>());
        map.get(0).add(-1);

        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(map.containsKey(sum)){
                for (int start:map.get(sum)) {
                    System.out.println("Subarray found from Index " + (start + 1) + " to " + i);
                }
            }
            map.putIfAbsent(sum,new ArrayList<>());
            map.get(sum).add(i);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println("Subarrays with sum 0:");
        findZeroSumSubarrays(arr1);

        System.out.println("\nAnother test case:");
        int[] arr2 = {1, 2, -3, 3, -1, -1};
        findZeroSumSubarrays(arr2);
    }
}

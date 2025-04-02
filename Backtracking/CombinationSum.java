package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        Arrays.sort(arr);
       List<List<Integer>> result = new ArrayList<>();
       findCombinations(arr,target,0,new ArrayList<>(),result);
       return result;
    }

    private static void findCombinations(int[] arr, int target, int index, List<Integer> current, List<List<Integer>> result) {
       if(target==0){
           result.add(new ArrayList<>(current));
           return;
       }

        for (int i = index; i <arr.length ; i++) {
            if(target<arr[i]) break;

            current.add(arr[i]);
            findCombinations(arr,target-arr[i],i,current,result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8}; // Input array
        int target = 8; // Target sum

        List<List<Integer>> result = combinationSum(arr, target);

        // Print results
        if (result.isEmpty()) {
            System.out.println("No valid combinations found.");
        } else {
            for (List<Integer> combination : result) {
                System.out.println(combination);
            }
        }
    }
}

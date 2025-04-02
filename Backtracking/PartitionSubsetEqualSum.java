package com.kunal.Dsa.Backtracking;

import java.util.Arrays;

public class PartitionSubsetEqualSum {
    public static boolean canPartitionKSubsets(int[] arr, int k) {
       int totalsum = 0;
        for (int num:arr) {
            totalsum+=num;
        }
        if(totalsum%k!=0) return false;

        Arrays.sort(arr);
        reverseArray(arr);

        int [] subsets = new int[k];

        return backtrack(arr,subsets,0,totalsum/k);
    }

    private static boolean backtrack(int[] arr, int[] subsets, int index, int target) {
       if(index==arr.length){
           for (int sum:subsets) {
               if(sum!=target){
                   return false;
               }
           }
           return true;
       }

        for (int i = 0; i < subsets.length; i++) {
            if(subsets[i]+arr[index]>target) continue;
            subsets[i]+=arr[index];
            if(backtrack(arr,subsets,index+1,target)){
                return true;
            }
            subsets[i]-=arr[index];
            if(subsets[i]==0) break;
        }
        return false;
    }
    private static void reverseArray(int[] arr) {
        int start=0;
        int end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 4, 5, 6};
        int k1 = 3;
        System.out.println(canPartitionKSubsets(arr1, k1)); // Output: true

        int[] arr2 = {2, 1, 5, 5, 6};
        int k2 = 3;
        System.out.println(canPartitionKSubsets(arr2, k2)); // Output: false
    }
}

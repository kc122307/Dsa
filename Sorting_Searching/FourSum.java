package com.kunal.Dsa.Sorting_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n= arr.length;

        List<List<Integer>> result = new ArrayList<>();
        if(n<4){
            return result;
        }

        Arrays.sort(arr);
        for (int i = 0; i < n-3; i++) {
            if(i>0&&arr[i]==arr[i-1]) continue;
            for (int j = i+1; j < n-2; j++) {
                if(j>i+1&&arr[j]==arr[j-1]) continue;
                int left=j+1,right=n-1;
                while(left<right){
                    long sum = (long) arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum==target){
                        result.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        while (left<right&&arr[left]==arr[left+1]) left++;
                        while (left<right&&arr[right]==arr[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(sum>target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {10, 11, 10, 12, 11};
        int target1 = 43;
        System.out.println(fourSum(arr1, target1));

        int[] arr2 = {10, 2, 3, 4, 5, 7, 8};
        int target2 = 23;
        System.out.println(fourSum(arr2, target2));

        int[] arr3 = {1, 1, 1, 1, 1, 1};
        int target3 = 4;
        System.out.println(fourSum(arr3, target3));
    }
}

package com.kunal.Dsa.Sorting_Searching;

import java.util.Arrays;

public class TripletsWithSumLessThan {
    static int countTriplets(int[] arr, int sum) {
        int n = arr.length;
       int count =0;
       Arrays.sort(arr);
        for (int i = 0; i <n ; i++) {
            int j=i+1,k=n-1;
            while(j<k){
                int currentsum = arr[i]+arr[j]+arr[k];
                if(currentsum<sum){
                    count+=(k-j);
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr1 = {-2, 0, 1, 3};
        int sum1 = 2;
        System.out.println(countTriplets(arr1, sum1)); // Output: 2

        int[] arr2 = {5, 1, 3, 4, 7};
        int sum2 = 12;
        System.out.println(countTriplets(arr2, sum2)); // Output: 4
    }
}


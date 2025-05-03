package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class LexicographicallySmallestArray {
    public static void minimizeArray(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i <n-1 &&k>0 ; i++) {
            int pos =i;
            for (int j = i+1; j <n && j<=i+k ; j++) {
                if(arr[j]<arr[pos]){
                    pos=j;
                }
            }

            for (int j = pos; j >i ; j--) {
               int temp =arr[j];
               arr[j]=arr[j-1];
               arr[j-1]=temp;
            }

            k-=(pos-i);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {7, 6, 9, 2, 1};
        int k1 = 3;

        minimizeArray(arr1, k1);
        System.out.println(Arrays.toString(arr1));  // Output: [2, 7, 6, 9, 1]

        int[] arr2 = {7, 6, 9, 2, 1};
        int k2 = 1;

        minimizeArray(arr2, k2);
        System.out.println(Arrays.toString(arr2));  // Output: [6, 7, 9, 2, 1]
    }
}

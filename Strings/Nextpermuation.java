package com.kunal.Dsa.Strings;

import java.util.Arrays;

public class Nextpermuation {
    static void nextpermutation(int [] arr){
       int n = arr.length;
       int pivot =-1;
        for (int i = n-2; i >=0 ; i--) {
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            reverse(arr,0,n-1);
            return;
        }
        for (int i = n-1; i >pivot ; i--) {
            if(arr[i]>arr[pivot]){
                swap(arr,i,pivot);
                break;
            }
        }
        reverse(arr,pivot+1,n-1);
    }
    static void reverse(int [] arr,int start,int end){
      while(start<end){
          swap(arr,start++,end--);
      }
    }
    static void swap(int[] arr,int start,int end){
       int temp = arr[start];
       arr[start]=arr[end];
       arr[end]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};
        nextpermutation(arr);
        System.out.println(Arrays.toString(arr)); // Output: [2, 4, 5, 0, 1, 7]

        int[] arr2 = {3, 2, 1};
        nextpermutation(arr2);
        System.out.println(Arrays.toString(arr2)); // Output: [1, 2, 3]

        int[] arr3 = {3, 4, 2, 5, 1};
        nextpermutation(arr3);
        System.out.println(Arrays.toString(arr3)); // Output: [3, 4, 5, 1, 2]
    }
}

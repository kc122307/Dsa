package com.kunal.Dsa.Sorting_Searching;

public class CeilingInSortedArray {
    public static int findCeiling(int[] arr, int x) {
       int low=0,high=arr.length-1;
       int result=-1;
       while (low<=high){
           int mid=low+(high-low)/2;
           if(arr[mid]==x){
               return mid;
           }
           else if (arr[mid]>x) {
               result= mid;
               high=mid-1;
           }
           else {
               low=mid+1;
           }
       }
       return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};

        System.out.println(findCeiling(arr, 5));  // Output: 2
        System.out.println(findCeiling(arr, 20)); // Output: -1
        System.out.println(findCeiling(new int[]{1, 1, 2, 8, 10, 10, 12, 19}, 0)); // Output: 0
    }
}

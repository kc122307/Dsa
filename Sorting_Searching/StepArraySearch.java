package com.kunal.Dsa.Sorting_Searching;

public class StepArraySearch {
    public static int findElement(int arr[], int k, int x) {
        int i =0;
       while(i<arr.length){
           if(arr[i]==x){
               return i;
           }
           int step = Math.max(1,Math.abs(arr[i]-x)/k);
           i+=step;
       }
       return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 6};
        int k1 = 1, x1 = 6;
        System.out.println(findElement(arr1, k1, x1)); // Output: 2

        int[] arr2 = {20, 40, 50, 70, 70, 60};
        int k2 = 20, x2 = 60;
        System.out.println(findElement(arr2, k2, x2)); // Output: 5
    }
}

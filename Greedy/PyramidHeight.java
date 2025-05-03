package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class PyramidHeight {
    public static int maxPyramidHeight(int[] arr) {
       Arrays.sort(arr);

       int n = arr.length;

       int totalboxes = 0;
       int height =0;

       while(totalboxes+height<=n){
           height++;
           totalboxes+=height;
       }
       return height;
    }
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {40, 100, 20, 30};
        System.out.println("Maximum Pyramid Height = " + maxPyramidHeight(arr1)); // Output: 2

        // Test Case 2
        int[] arr2 = {10, 20, 30, 50, 60, 70};
        System.out.println("Maximum Pyramid Height = " + maxPyramidHeight(arr2)); // Output: 3
    }
}

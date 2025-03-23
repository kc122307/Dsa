package com.kunal.Dsa.Sorting_Searching;

import java.util.Arrays;

public class MergeAndRearrange {
    static void mergeAndRearrange(int[] a, int[] b) {
       int m = a.length;
       int n = b.length;
       int i=0,j=0,k=0;
       int [] merge = new int[n+m];
       while(i<m&&j<n){
           if(a[i]<b[j]){
               merge[k++]=a[i++];
           }
           else{
               merge[k++]=b[j++];
           }
       }
       while(i<m){
           merge[k++]=a[i++];
       }
        while(j<n){
            merge[k++]=b[j++];
        }

        for (i = 0; i < m; i++) {
            a[i]=merge[i];
        }
        for (i = 0; i < n; i++) {
            b[i]=merge[i+m];
        }
    }
    public static void main(String[] args) {
        int[] a1 = {2, 4, 7, 10};
        int[] b1 = {2, 3};
        mergeAndRearrange(a1, b1);
        System.out.println("a[]: " + Arrays.toString(a1)); // Output: [2, 2, 3, 4]
        System.out.println("b[]: " + Arrays.toString(b1)); // Output: [7, 10]

        int[] a2 = {1, 5, 9, 10, 15, 20};
        int[] b2 = {2, 3, 8, 13};
        mergeAndRearrange(a2, b2);
        System.out.println("a[]: " + Arrays.toString(a2)); // Output: [1, 2, 3, 5, 8, 9]
        System.out.println("b[]: " + Arrays.toString(b2)); // Output: [10, 13, 15, 20]

        int[] a3 = {0, 1};
        int[] b3 = {2, 3};
        mergeAndRearrange(a3, b3);
        System.out.println("a[]: " + Arrays.toString(a3)); // Output: [0, 1]
        System.out.println("b[]: " + Arrays.toString(b3)); // Output: [2, 3]
    }
}

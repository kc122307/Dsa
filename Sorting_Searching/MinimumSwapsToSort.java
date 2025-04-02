package com.kunal.Dsa.Sorting_Searching;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwapsToSort {
    static int minSwaps(int[] arr) {
      int n= arr.length;
      int swaps=0;
      boolean [] visited = new boolean[n];

      int pairs[][]= new int[n][2];
      for (int i = 0; i < n; i++) {
          pairs[i][0]=arr[i];
          pairs[i][1]=i;
      }

      Arrays.sort(pairs,Comparator.comparingInt(a->a[0]));
      for (int i = 0; i <n ; i++) {
          if(visited[i]||pairs[i][1]==i) continue;
          int j = i;
          int cycleSize=0;
          while(!visited[j]){
              visited[j]=true;
              j= pairs[j][1];
              cycleSize++;
          }
          if(cycleSize>1){
              swaps+=(cycleSize-1);
          }
      }
      return swaps;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println("Minimum swaps required: " + minSwaps(arr));

        int[] arr2 = {10, 19, 6, 3, 5};
        System.out.println("Minimum swaps required: " + minSwaps(arr2));

        int[] arr3 = {1, 3, 4, 5, 6};
        System.out.println("Minimum swaps required: " + minSwaps(arr3));
    }

}

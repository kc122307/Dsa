package com.kunal.Dsa.Sorting_Searching;

import java.util.Arrays;

public class CountSort {
    public static void countsort(int[]arr){
      if(arr==null||arr.length==0){
          return;
      }

      int min= arr[0],max=arr[0];
        for (int num:arr) {
            if(num<min) min = num;
            if(num>max) max = num;
        }

        int range = max-min+1;
        int countarray[] = new int[range];

        for (int num:arr) {
            countarray[num-min]++;
        }

        int index=0;
        for (int i = 0; i <range; i++) {
            while(countarray[i]>0){
                arr[index++]=i+min;
                countarray[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 10, 9, 2, 4, 9, 7};
        countsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package com.kunal.Dsa.Arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    static int mindiff(int [] arr,int m){
       int n = arr.length;
       Arrays.sort(arr);
       int min_diff= Integer.MAX_VALUE;
       for(int i=0;i+m-1 <n; i++){
           int diff = arr[i+m-1] - arr[i];
           min_diff= Math.min(diff,min_diff);
       }
       return min_diff;
    }
    public static void main(String[] args) {
        int[] arr ={7, 3, 2, 4, 9, 12, 56};
        int ans = mindiff(arr,5);
        System.out.println(ans);
    }
}

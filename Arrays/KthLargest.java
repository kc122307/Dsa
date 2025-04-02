package com.kunal.Dsa.Arrays;

public class KthLargest {
    static int find(int [] arr,int k){
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int num:arr){
           minValue = Math.min(num,minValue);
           maxValue = Math.max(num,maxValue);
        }

       int [] count = new int [maxValue-minValue+1];
        for(int num:arr){
            count[num-minValue]++;
        }
       int remain=k;
        for (int n = count.length-1 ;n >=0 ; n--) {
            remain-=count[n];
            if(remain<=0){
                return n+minValue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {16, 18, 5, 7, 19};
        int K = 2;
        System.out.println(find(arr, K));
    }
}

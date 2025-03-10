package com.kunal.Dsa;

public class MaxSumSubArray {
    static int maxsum(int [] arr){
        int ans = Integer.MIN_VALUE;
        int total =0;
        for(int n:arr){
            if(total<0) total=0;

            total +=n;
            ans = Integer.max(ans,total);
        }
        return  ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,-4};
        int ans = maxsum(arr);
        System.out.println(ans);
    }
}

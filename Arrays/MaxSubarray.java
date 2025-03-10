package com.kunal.Dsa;

public class MaxSubarray {
    static int maxsubarray(int [] arr){
        int n =arr.length;
        int maxi= Integer.MIN_VALUE;
        int pre=1;
        int suf=1;
        for (int i = 0; i <n; i++) {
            if(pre==0) pre=1;
            if(suf==0) suf=1;
            pre=pre*arr[i];
            suf=suf*arr[n-i-1];
            maxi= Integer.max(maxi,Integer.max(pre,suf));
        }
        return maxi;
    }
    public static void main(String[] args) {
        int [] arr ={5,4,-1,7,};
        int ans = maxsubarray(arr);
        System.out.println(ans);
    }
}

package com.kunal.Dsa.HeapsandHashing;

import java.util.HashMap;

public class LongestZeroSumSubarray {
    public static int maxLen(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum =0;
        int maxlen =0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum==0){
                maxlen=i+1;
            }
            if(hashMap.containsKey(sum)){
                maxlen=Math.max(maxlen,i- hashMap.get(sum));
            }
            else {
                hashMap.put(sum,i);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of longest subarray with 0 sum: " + maxLen(arr1)); // 5

        int[] arr2 = {1, 2, 3};
        System.out.println("Length of longest subarray with 0 sum: " + maxLen(arr2)); // 0

        int[] arr3 = {1, 0, 3};
        System.out.println("Length of longest subarray with 0 sum: " + maxLen(arr3)); // 1
    }
}

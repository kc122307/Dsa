package com.kunal.Dsa.HeapsandHashing;

import java.util.HashSet;

public class LongestContiguousSubarray {
    public static int longestContiguousSubarray(int[] arr) {
       int n =arr.length;
       int maxlen =1;
        for (int i = 0; i < n; i++) {
            int max=arr[i],min=arr[i];
            HashSet<Integer> set=new HashSet<>();
            set.add(arr[i]);

            for (int j = i+1; j <n ; j++) {
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                max=Math.max(arr[j],max);
                min=Math.min(arr[j],min);

                if(max-min==j-i){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr1 = {10, 12, 11};
        System.out.println("Length of longest contiguous subarray: " + longestContiguousSubarray(arr1));

        int[] arr2 = {10, 12, 12, 10, 10, 11, 10};
        System.out.println("Length of longest contiguous subarray: " + longestContiguousSubarray(arr2));
    }
}

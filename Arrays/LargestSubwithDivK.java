package com.kunal.Dsa.Arrays;

import java.util.HashMap;

public class LargestSubwithDivK {
    static int largest(int [] arr,int k){
      int n = arr.length;
      HashMap<Integer,Integer> map= new HashMap<>();
      int sum = 0;
      int res = 0;
        for (int i = 0; i < n; i++) {
            sum=((sum+arr[i])%k+k)%k;
            if(sum==0){
                res=i+1;
            }
            else if (map.containsKey(sum)) {
                res= Math.max(res,i-map.get(sum));
            }
            else {
                map.put(sum,i);
            }
        }
      return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;

        System.out.println(largest(arr, k));
    }
}

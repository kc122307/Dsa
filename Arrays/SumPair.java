package com.kunal.Dsa;

import java.util.Arrays;

public class SumPair {
    static boolean find(int [] arr, int target){
        Arrays.sort(arr);
        int left =0;
        int right= arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum==target){
                return true;
            }
            else if (sum>target) {
                right--;
            }
            else {
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int target = 16;
        if (find(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class MaximizeSumOfDifferences {
    public static int maximizeSum(int[] arr) {
       int n = arr.length;
       Arrays.sort(arr);

       if(n==1){
           return 0;
       }

       int [] rearranged = new int[n];
       int left=0,right=n-1,index=0;

       while(left<right){
           rearranged[index++]=arr[left++];
           rearranged[index++]=arr[right--];
       }

       if(left==right){
           rearranged[index]=arr[left];
       }

       int sum =0;
        for (int i = 0; i < n; i++) {
            sum+=Math.abs(rearranged[i]-rearranged[(i+1)%n]);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr1 = { 4, 2, 1, 8 };
        int[] arr2 = { 10, 12, 15 };

        System.out.println(maximizeSum(arr1));  // Output: 18
        System.out.println(maximizeSum(arr2));  // Output: 10
    }
}

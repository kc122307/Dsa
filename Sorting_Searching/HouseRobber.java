package com.kunal.Dsa.Sorting_Searching;

public class HouseRobber {
    static int findMaxSum(int[] arr) {
        int n= arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];

        int prev2=0;
        int prev1 =arr[0];
        for (int i = 1; i < n; i++) {
            int current = Math.max(prev1,prev2+arr[i]);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 5, 7, 4};
        System.out.println(findMaxSum(arr));  // Output: 13
    }
}

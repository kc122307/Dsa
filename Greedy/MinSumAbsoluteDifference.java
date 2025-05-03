package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class MinSumAbsoluteDifference {
    public static int minSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int n= a.length;
        int sum=0;

        for (int i = 0; i < n; i++) {
            sum+=Math.abs(a[i]-b[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        // Test Case 1
        int[] a1 = {3, 2, 1};
        int[] b1 = {2, 1, 3};
        System.out.println("Minimum Sum of Absolute Differences = " + minSum(a1, b1)); // Output: 0

        // Test Case 2
        int[] a2 = {4, 1, 8, 7};
        int[] b2 = {2, 3, 6, 5};
        System.out.println("Minimum Sum of Absolute Differences = " + minSum(a2, b2)); // Output: 6
    }
}

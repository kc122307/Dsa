package com.kunal.Dsa;

public class Sumsubarray {
    static int find(int [] nums,int k){
        int[] remainderCount = new int[k]; // Array instead of HashMap
        remainderCount[0] = 1; // Initialize for subarrays starting from index 0

        int sum = 0, count = 0;

        for (int num : nums) {
            sum = ((sum + num) % k + k) % k; // Ensure non-negative remainder

            count += remainderCount[sum]; // Add occurrences of the same remainder

            remainderCount[sum]++; // Increment remainder frequency
        }

        return count;
    }
}

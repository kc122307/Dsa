package com.kunal.Dsa.Backtracking;

public class MaxNumberSwaps {
    static String maxNum; // To store the maximum number found during the recursive process

    // Helper function to swap characters in a string
    public static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    // Recursive function to find the maximum number possible after at most k swaps
    private static void findMax(String s, int k, int index) {

        if(s.compareTo(maxNum) > 0) {
            maxNum = s;  // Corrected the assignment
        }

        if(k == 0 )  return;

        int n = s.length();

        for(int i = index; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(s.charAt(j) > s.charAt(i)) {
                    String swapped = swap(s, i, j);
                    findMax(swapped, k-1, i);  // Pass swapped string, not original s
                }
            }
        }
    }

    // Main function to get the maximum number after at most k swaps
    public static String getMaxNumber(String s, int k) {
        maxNum = s;  // Initialize maxNum with the original string
        findMax(s, k, 0);
        return maxNum;
    }

    // Main method for testing
    public static void main(String[] args) {
        String s1 = "7599";
        int k1 = 2;
        System.out.println("Max number: " + getMaxNumber(s1, k1)); // Output: 9975

        String s2 = "76543";
        int k2 = 1;
        System.out.println("Max number: " + getMaxNumber(s2, k2)); // Output: 76543
    }
}
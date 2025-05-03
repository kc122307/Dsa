package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class MinSumTwoNumbers {
    public static int minSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                num1.append(arr[i]);
            }
            else{
                num2.append(arr[i]);
            }
        }

        int n1 = Integer.parseInt(num1.toString());
        int n2 = Integer.parseInt(num2.toString());

        return n1+n2;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 8, 4, 5, 2, 3};
        System.out.println("Minimum Sum = " + minSum(arr1)); // Output: 604

        int[] arr2 = {5, 3, 0, 7, 4};
        System.out.println("Minimum Sum = " + minSum(arr2)); // Output: 82
    }
}

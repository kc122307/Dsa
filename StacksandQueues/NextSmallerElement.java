package com.kunal.Dsa.StacksandQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] findNextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while(!stack.isEmpty()&&stack.peek()>=arr[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {4, 8, 5, 2, 25};
        int[] result1 = findNextSmallerElements(arr1);
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(result1));

        int[] arr2 = {13, 7, 6, 12};
        int[] result2 = findNextSmallerElements(arr2);
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(result2));
    }
}

package com.kunal.Dsa.StacksandQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] findNextGreaterElements(int[] arr) {
       int n = arr.length;
       int [] result = new int[n];
       Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]){
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return  result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Next Greater Elements: " + Arrays.toString(findNextGreaterElements(arr)));
    }
}

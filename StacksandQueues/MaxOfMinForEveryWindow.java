package com.kunal.Dsa.StacksandQueues;

import java.util.Arrays;
import java.util.Stack;

public class MaxOfMinForEveryWindow {
    public static int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int [] left = new int[n];
        int [] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <n ; i++) {
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();

        for (int i =n-1; i>=0 ;i--) {
            while (!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()? n :stack.peek();
            stack.push(i);
        }

        int [] ans = new int[n+1];
        Arrays.fill(ans,Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int len = right[i]-left[i]-1;
            ans[len] = Math.max(ans[len],arr[i]);
        }

        for (int i = n-1; i >=1 ; i--) {
            ans[i]=Math.max(ans[i],ans[i+1]);
        }

        int [] result = new int[n];

        for (int i = 1; i <= n; i++) {
            result[i-1]=ans[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        System.out.println(Arrays.toString(maxOfMin(arr1)));  // Output: [30, 20, 10]

        int[] arr2 = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(Arrays.toString(maxOfMin(arr2)));  // Output: [70, 30, 20, 10, 10, 10, 10]
    }
}

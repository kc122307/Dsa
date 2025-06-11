package com.kunal.Dsa.HeapsandHashing;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int [] nge =new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i]=-1;
            }
            else {
                nge[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return nge;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElements(arr)));

        int[] arr2 = {6, 8, 0, 1, 3};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElements(arr2)));

        int[] arr3 = {50, 40, 30, 10};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElements(arr3)));
    }
}

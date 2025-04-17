package com.kunal.Dsa.StacksandQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutationCheck {
    public static boolean isStackPermutation(int[] input, int[] output) {
        Stack<Integer> stack= new Stack<>();
        Queue<Integer> inputQueue = new LinkedList<>();
        Queue<Integer> outputQueue = new LinkedList<>();

        for (int num:input) inputQueue.add(num);
        for (int num:output) outputQueue.add(num);

        while(!inputQueue.isEmpty()){
            stack.push(inputQueue.poll());
            while(!stack.isEmpty()&&!outputQueue.isEmpty()&&stack.peek().equals(outputQueue.peek())){
                stack.pop();
                outputQueue.poll();
            }
        }
        return stack.isEmpty()&&outputQueue.isEmpty();
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};

        System.out.println(isStackPermutation(a, b)); // true

        int[] c = {1, 2, 3};
        int[] d = {3, 1, 2};

        System.out.println(isStackPermutation(c, d)); // false
    }
}

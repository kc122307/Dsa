package com.kunal.Dsa.StacksandQueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static Queue<Integer> reverseK(Queue<Integer> queue, int k) {
        if(queue==null||k<=0||k>queue.size()){
            return queue;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        for (int i = 0; i < queue.size()-k; i++) {
            queue.add(queue.remove());
        }
        return queue;
    }
    public static void printQueue(Queue<Integer> queue) {
        for (int num : queue) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k1 = 3;
        System.out.print("Original Queue: ");
        printQueue(q1);
        q1 = reverseK(q1, k1);
        System.out.print("After reversing first " + k1 + " elements: ");
        printQueue(q1);

        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(4, 3, 2, 1));
        int k2 = 4;
        System.out.print("Original Queue: ");
        printQueue(q2);
        q2 = reverseK(q2, k2);
        System.out.print("After reversing first " + k2 + " elements: ");
        printQueue(q2);
    }
}

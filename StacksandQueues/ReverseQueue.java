package com.kunal.Dsa.StacksandQueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> q) {
       Stack<Integer> stack = new Stack<>();
       while(!q.isEmpty()){
           stack.push(q.poll());
       }
       while(!stack.isEmpty()){
           q.add(stack.pop());
       }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(4, 3, 1, 10, 2, 6));
        System.out.println("Original Queue: " + q);
        reverseQueue(q);
        System.out.println("Reversed Queue: " + q);
    }
}

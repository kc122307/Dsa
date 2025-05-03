package com.kunal.Dsa.StacksandQueues;

import java.util.Stack;

public class StackSorter {
    static void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()){
            int temp =stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack,temp);
        }
    }
    static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if(stack.isEmpty()||stack.peek()<=element){
            stack.push(element);
        }
        else{
            int temp = stack.pop();
            insertInSortedOrder(stack,element);
            stack.push(temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(30);
        st.push(-5);
        st.push(18);
        st.push(14);
        st.push(-3);

        System.out.println("Original Stack: " + st);
        sortStack(st);
        System.out.print("Sorted Stack: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
}

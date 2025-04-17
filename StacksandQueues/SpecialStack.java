package com.kunal.Dsa.StacksandQueues;

import java.util.Locale;
import java.util.Stack;

public class SpecialStack {
    Stack<Long> stack = new Stack<>();
    long min;

    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public boolean isFull(){
        return stack.size()==1000;
    }

    public void push(int x) {
       if(stack.isEmpty()){
           stack.push((long)x);
           min=(long) x;
       }
       else if(min<=x){
           stack.push((long)x);
       }
       else {
           stack.push(2L*x-min);
           min=x;
       }
    }
    public int pop(){
       if(stack.isEmpty()){
           throw new RuntimeException("Stack is Empty");
       }
       long top = stack.pop();
       if(top>=min){
           return (int) top;
       }
       else{
           int actualmin = (int) min;
           min=2*min-top;
           return actualmin;
       }
    }
    public int getMin(){
       if(stack.isEmpty()){
           throw new RuntimeException("Stack is Empty");
       }
       return (int) min;
    }
    public int peek(){
       if(stack.isEmpty()){
           throw new RuntimeException();
       }
       long top =stack.peek();
       if(top>=min){
           return (int) top;
       }
       else{
           return (int) min;
       }
    }
        public static void main(String[] args) {
            SpecialStack s = new SpecialStack();

            s.push(3);
            s.push(5);
            System.out.println("Min: " + s.getMin()); // 3

            s.push(2);
            s.push(1);
            System.out.println("Min: " + s.getMin()); // 1

            s.pop();
            System.out.println("Min: " + s.getMin()); // 2

            s.pop();
            System.out.println("Min: " + s.getMin()); // 3
        }
    }

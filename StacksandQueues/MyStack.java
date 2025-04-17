package com.kunal.Dsa.StacksandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;
    MyStack(){
        queue= new LinkedList<>();
    }
    public void push(int x){
       queue.add(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("Kunal it is Empty");
        }
        return queue.poll();
    }

    public int top(){
      if(queue.isEmpty()){
          throw  new RuntimeException("It is Empty");
      }
      return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);                    // [1]
        myStack.push(2);                    // [2, 1]
        System.out.println(myStack.top());  // Output: 2
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());// Output: 2
        System.out.println(myStack.empty()); // Output: false
    }
}

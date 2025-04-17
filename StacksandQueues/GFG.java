package com.kunal.Dsa.StacksandQueues;

public class GFG {
    static class DQueNode {
        int value;
        DQueNode next;
        DQueNode prev;
    }
    static class deque {
        private DQueNode head;
        private DQueNode tail;
        public deque(){head=tail=null;}

        boolean isEmpty(){
            if(head==null){
                return true;
            }
            return false;
        }

        int size(){
            if(!isEmpty()){
                DQueNode temp=head;
                int len =0;
                while(temp!=null){
                    len++;
                    temp=temp.next;
                }
                return len;
            }
            return 0;
        }

        void insert_first(int element){
            DQueNode temp = new DQueNode();
            temp.value=element;
            if(head==null){
                head=tail=temp;
                temp.prev=temp.next=null;
            }
            else{
                head.prev=temp;
                temp.next=head;
                temp.prev=null;
                head=temp;
            }
        }

        void insert_last(int element){
            DQueNode temp = new DQueNode();
            temp.value=element;
            if(head==null){
                head=tail=temp;
                temp.prev=temp.next=null;
            }
            else{
                tail.next=temp;
                temp.prev=tail;
                temp.next=null;
                tail=temp;
            }
        }
        public void remove_first(){
            if(!isEmpty()){
                if(head==tail){
                    head=tail=null;
                    return;
                }
                else {
                    head= head.next;
                    head.prev=null;
                }
            }
            else{
                System.out.println("List is Empty");
            }
        }

        void remove_last(){
            if(!isEmpty()){
                if(head==tail){
                    head=tail=null;
                }
                else {
                    tail=tail.prev;
                    tail.next=null;
                }
            }
            else{
                System.out.println("List is Empty");
            }
        }

        void display(){
            if(!isEmpty()){
                DQueNode temp = head;
                while (temp!=null){
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }
                return;
            }
            System.out.print("List is Empty");
        }
    }

    static class Queue {
        deque q = new deque();
        public void enqueue(int element){
            q.insert_last(element);
        }

        public void dequeue(){
            q.remove_first();
        }
        public void display() { q.display(); }

        public int size() { return q.size(); }
    }

    static class Stack {
        deque q= new deque();
        public void push(int element)
        {
            q.insert_last(element);
        }

        public int size() { return q.size(); }


        public void pop() { q.remove_last(); }
        public void display() { q.display(); }
    }
    public static void main(String[] args)
    {

        // Object of Stack
        Stack stk = new Stack();

        // push 7 and 8 at top of stack
        stk.push(7);
        stk.push(8);
        System.out.print("Stack: ");
        stk.display();

        // For new line
        System.out.println();

        // pop an element
        stk.pop();
        System.out.print("Stack: ");
        stk.display();

        // For new line
        System.out.println();

        // Object of Queue
        Queue que = new Queue();

        // Insert 12 and 13 in queue
        que.enqueue(12);
        que.enqueue(13);
        System.out.print("Queue: ");
        que.display();

        // New line
        System.out.println();

        que.dequeue();
        System.out.print("Queue: ");
        que.display();

        // New line
        System.out.println();
        System.out.println("Size of stack is "
                + stk.size());
        System.out.println("Size of queue is "
                + que.size());
    }

}

package com.kunal.Dsa.StacksandQueues;

public class StackWithMiddleOps {
    static class DLLNode{
        int data;
        DLLNode prev,next;
        DLLNode(int data){
            this.data=data;
        }
    }
    static class MyStack {
        private DLLNode head;
        private DLLNode mid;
        private int count=0;

        void push(int x) {
            DLLNode newnode = new DLLNode(x);
            newnode.next=head;
            if(head!=null) head.prev=newnode;
            head=newnode;

            count++;
            if(count==1){
                mid=head;
            }
            else if (count%2==0) {
                mid=mid.prev;
            }
        }

        int pop(){
            if(count==0){
                System.out.println("Stack is Empty");
                return -1;
            }

            int topData = head.data;
            head=head.next;

            if(head!=null) head.prev=null;

            count--;
            if(count==0){
                mid=null;
            }
            else if (count%2!=0&&mid!=null) {
                mid=mid.next;
            }
            return topData;

        }

        int findMiddle() {
           if(mid==null){
               System.out.println("Stack is Empty");
               return -1;
           }
           return mid.data;
        }

        int deleteMiddle() {
            if (mid == null) {
                System.out.println("Stack is empty");
                return -1;
            }

            int midData = mid.data;

            if (count == 1) {
                head = null;
                mid = null;
                count--;
                return midData;
            }

            if (mid.prev != null) mid.prev.next = mid.next;
            if (mid.next != null) mid.next.prev = mid.prev;

            if (count % 2 == 0) {
                mid = mid.next;
            } else {
                mid = mid.prev;
            }

            count--;
            return midData;
        }
    }
        public static void main(String[] args) {
            MyStack stack = new MyStack();

            stack.push(1);
            stack.push(2);

            System.out.println("Middle Element: " + stack.findMiddle()); // 2
            System.out.println("Popped: " + stack.pop());                // 2
            System.out.println("Deleted Middle: " + stack.deleteMiddle()); // 1
        }
}

package com.kunal.Dsa.LinkedList;

import java.util.Stack;

public class ArbitPointerLinkedList {
    private static ListNode reverse(ListNode head) {
        ListNode prev =null,curr=head,next;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static ListNode pointToNextHigher(ListNode head) {
      if(head==null) return null;
      head=reverse(head);
      Stack<ListNode> stack = new Stack<>();
      ListNode curr = head;
      while(curr!=null){
          while(!stack.isEmpty()&&stack.peek().val<=curr.val){
              stack.pop();
          }
          curr.arbit= stack.isEmpty()?null:stack.peek();
          stack.push(curr);
          curr=curr.next;
      }
      return reverse(head);
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "(" + (head.arbit != null ? head.arbit.val : "NULL") + ") → ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);

        head = pointToNextHigher(head);

        printList(head); // Expected Output: 12(15) → 15(NULL) → 10(11) → 11(NULL) → 5(6) → 6(NULL) → 2(NULL) → 3(NULL) → NULL
    }
}

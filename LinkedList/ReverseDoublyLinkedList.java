package com.kunal.Dsa.LinkedList;

public class ReverseDoublyLinkedList {
    public static ListNode reverse(ListNode head) {
       if(head==null||head.next==null) return head;
       ListNode temp=null;
       ListNode curr=head;
       while(curr!=null){
           temp=curr.prev;
           curr.prev=curr.next;
           curr.next=temp;
           curr=curr.prev;
       }
      return temp.prev;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ⇄ ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.prev = head;
        head.next.next = new ListNode(30);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode(40);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed Doubly Linked List:");
        printList(head);
    }
}

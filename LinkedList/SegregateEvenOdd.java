package com.kunal.Dsa.LinkedList;

public class SegregateEvenOdd {
    public static ListNode segregateEvenOdd(ListNode head) {
       if(head==null) return null;
       ListNode Evenstart=null,Evenend =null;
       ListNode Oddstart=null,Oddend =null;
       ListNode current = head;
       while(current!=null){
            int val = current.val;
            if(val%2==0){
                if(Evenstart==null){
                    Evenstart=Evenend=current;
                }
                else{
                    Evenend.next=current;
                    Evenend=Evenend.next;
                }
            }
            else{
                if(Oddstart==null){
                    Oddstart=Oddend=current;
                }
                else{
                    Oddend.next=current;
                    Oddend=Oddend.next;
                }
            }
            current=current.next;
       }

       if(Evenstart==null) return Oddstart;
       Evenend.next=Oddstart;

       if(Oddend!=null) Oddend.next=null;
       return Evenstart;
    }
    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(17);
        head.next = new ListNode(15);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        printList(head);

        head = segregateEvenOdd(head);

        System.out.println("Modified List:");
        printList(head);
    }
}

package com.kunal.Dsa.LinkedList;

public class FlattenLinkedList {
    public static ListNode merge(ListNode a, ListNode b) {
       if(a==null) return b;
       if(b==null) return a;

       ListNode result ;
       if(a.val<b.val){
           result=a;
           result.bottom=merge(a.bottom,b);
       }
       else{
           result=b;
           result.bottom=merge(a,b.bottom);
       }
       result.next=null;
       return result;
    }
    public static ListNode flatten(ListNode head) {
        if(head==null||head.next==null) return head;

        head.next= flatten(head.next);

        head=merge(head,head.next);

        return head;
    }
    // Function to print flattened list using bottom pointer
    public static void printFlattenedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.bottom;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample Input:
        ListNode head = new ListNode(5);
        head.bottom = new ListNode(7);
        head.bottom.bottom = new ListNode(8);
        head.bottom.bottom.bottom = new ListNode(30);

        head.next = new ListNode(10);
        head.next.bottom = new ListNode(20);

        head.next.next = new ListNode(19);
        head.next.next.bottom = new ListNode(22);
        head.next.next.bottom.bottom = new ListNode(50);

        head.next.next.next = new ListNode(28);
        head.next.next.next.bottom = new ListNode(35);
        head.next.next.next.bottom.bottom = new ListNode(40);
        head.next.next.next.bottom.bottom.bottom = new ListNode(45);

        // Flatten and print the list
        ListNode flat = flatten(head);
        printFlattenedList(flat);
    }
}

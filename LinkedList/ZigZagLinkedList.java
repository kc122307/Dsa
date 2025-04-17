package com.kunal.Dsa.LinkedList;

public class ZigZagLinkedList {
    public static void zigZagList(ListNode head) {
        if(head==null&&head.next==null) return;
        boolean flag =true;
        ListNode current = head;
        while(current!=null&&current.next!=null){
            if(flag){
                if(current.val>current.next.val){
                    swap(current,current.next);
                }
            }
            else{
                if(current.val<current.next.val){
                    swap(current,current.next);
                }
            }
            flag=!flag;
            current=current.next;
        }
    }
    private static void swap(ListNode a, ListNode b) {
      int temp =a.val;
      a.val=b.val;
      b.val=temp;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(15);
        head.next.next = new ListNode(20);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);

        System.out.println("Original List:");
        printList(head);

        zigZagList(head);

        System.out.println("Zig-Zag List:");
        printList(head);
    }
}

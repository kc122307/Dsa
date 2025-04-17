package com.kunal.Dsa.LinkedList;

public class RearrangeLinkedList {
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode slow =head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode secondhalf = reverse(slow.next);
        slow.next=null;
        ListNode firsthalf = head;
        while(firsthalf!=null && secondhalf!=null){
            ListNode temp1= firsthalf.next;
            ListNode temp2 = secondhalf.next;

            firsthalf.next=secondhalf;
            secondhalf.next=temp1;

            firsthalf=temp1;
            secondhalf=temp2;
        }
    }
    private static ListNode reverse(ListNode head) {
        ListNode prev =null;
        while(head!=null){
            ListNode next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        reorderList(head);

        System.out.println("Reordered List:");
        printList(head);
    }
}

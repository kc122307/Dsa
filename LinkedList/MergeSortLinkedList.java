package com.kunal.Dsa.LinkedList;

public class MergeSortLinkedList {
    public static ListNode mergeSort(ListNode head) {
       if(head==null||head.next==null) return head;

       ListNode middle=getMiddle(head);
       ListNode nextOfMiddle = middle.next;
       middle.next=null;

       ListNode left = mergeSort(head);
       ListNode right = mergeSort(nextOfMiddle);
       return merge(left,right);
    }

    public static ListNode getMiddle(ListNode head) {
        if(head==null) return head;
        ListNode slow =head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail =dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else {
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1!=null) tail.next=l1;
        else tail.next=l2;
        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Test case
    public static void main(String[] args) {
        ListNode head = new ListNode(40);
        head.next = new ListNode(20);
        head.next.next = new ListNode(60);
        head.next.next.next = new ListNode(10);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(30);

        System.out.println("Original List:");
        printList(head);

        head = mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}

package com.kunal.Dsa.LinkedList;

import java.util.HashSet;

public class RemoveDuplicates {
    public static ListNode removeDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode current = head;
        ListNode prev = null;
        HashSet<Integer> seen = new HashSet<>();
        while(current!=null){
            if(seen.contains(current.val)){
                prev.next=current.next;
            }
            else{
                seen.add(current.val);
                prev=current;
            }
            current=current.next;
        }
        return head;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        head.next = new ListNode(11);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(21);
        head.next.next.next.next = new ListNode(41);
        head.next.next.next.next.next = new ListNode(43);
        head.next.next.next.next.next.next = new ListNode(21);

        System.out.println("Original List:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("After Removing Duplicates:");
        printList(head);
    }
}

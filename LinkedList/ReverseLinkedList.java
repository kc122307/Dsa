package com.kunal.Dsa.LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head){
       ListNode prev = null;
       ListNode curr = head;
       while(curr!=null){
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr= next;
       }
       return prev;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static ListNode arrayToList(int[] arr) {
        if (arr.length==0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length ; i++) {
            current.next= new ListNode(arr[i]);
            current=current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = arrayToList(arr);

        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}

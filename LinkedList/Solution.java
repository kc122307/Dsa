package com.kunal.Dsa.LinkedList;

public class Solution {
    public void reorderList(ListNode head) {
     if(head==null||head.next==null) return;
     ListNode slow = head;
     ListNode fast = head;
     while(fast!=null&&fast.next!=null){
         slow=slow.next;
         fast=fast.next.next;
     }
     ListNode prev = null, curr = slow.next;
     slow.next=null;
     while(curr!=null){
         ListNode temp = curr.next;
         curr.next=prev;
         prev=curr;
         curr=temp;
     }

     ListNode firsthalf = head;
     ListNode secondhalf =prev;
     while(secondhalf!=null){
         ListNode temp1 = firsthalf.next;
         ListNode temp2 = secondhalf.next;

         firsthalf.next=secondhalf;
         secondhalf.next=temp1;

         firsthalf=temp1;
         secondhalf=temp2;
     }
}
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        solution.reorderList(head);

        System.out.println("Reordered List:");
        printList(head);
    }
}


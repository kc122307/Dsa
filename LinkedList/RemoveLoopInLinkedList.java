package com.kunal.Dsa.LinkedList;

public class RemoveLoopInLinkedList {
    public void removeLoop(ListNode head) {
     if(head==null||head.next==null) return;
     ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(slow==fast) break;
        }
        if(fast==null||fast.next==null) return;

        slow=head;
        ListNode prev = null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }
    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Test the function
    public static void main(String[] args) {
        RemoveLoopInLinkedList solution = new RemoveLoopInLinkedList();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> back to 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Creating a loop at node 3

        // Detect and remove the loop
        solution.removeLoop(head);

        // Print the corrected list
        printList(head);
    }
}

package com.kunal.Dsa.LinkedList;

public class CloneLinkedList{
    public static ListNode cloneList(ListNode head) {
       if(head==null) return null;
       ListNode curr=head;
       while(curr!=null){
           ListNode cloned = new ListNode(curr.val);
           cloned.next=curr.next;
           curr.next=cloned;
           curr=cloned.next;
       }

        curr=head;
       while(curr!=null){
           if(curr.random!=null){
               curr.next.random= curr.random.next;
           }
           curr=curr.next.next;
       }

       curr=head;
       ListNode dummy = new ListNode(0);
       ListNode copy = dummy;
       while(curr!=null){
           copy.next=curr.next;
           curr.next=curr.next.next;
           curr=curr.next;
           copy=copy.next;
       }
       return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            int randomVal = (head.random != null) ? head.random.val : -1;
            System.out.println("Value: " + head.val + ", Random: " + randomVal);
            head = head.next;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Setting up random pointers
        head.random = head.next.next;           // 1 -> 3
        head.next.random = head;                // 2 -> 1
        head.next.next.random = head.next.next; // 3 -> 3
        head.next.next.next.random = head.next; // 4 -> 2

        System.out.println("Original list:");
        printList(head);

        ListNode clonedHead = cloneList(head);

        System.out.println("\nCloned list:");
        printList(clonedHead);
    }
}

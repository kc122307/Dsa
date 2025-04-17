package com.kunal.Dsa.LinkedList;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next=head;
      ListNode first=head,second=head;
        for (int i = 0; i <=n ; i++) {
            first=first.next;
        }

        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5], n = 2 → Output: [1,2,3,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);
        head = removeNthFromEnd(head, 2);
        System.out.print("After Removal: ");
        printList(head);
    }
}

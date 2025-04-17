package com.kunal.Dsa.LinkedList;

public class SortLinkedList {
    public static ListNode sortList(ListNode head) {
        if(head==null) return null;
        int []count={0,0,0};
        ListNode temp =head;
        while(temp!=null){
            count[temp.val]++;
            temp=temp.next;
        }
        temp=head;

        for (int i = 0; i < 3; i++) {
            while(count[i]>0){
                temp.val=i;
                temp=temp.next;
                count[i]--;
            }
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(1);

        System.out.println("Original List:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}

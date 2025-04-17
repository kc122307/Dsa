package com.kunal.Dsa.LinkedList;

public class DeleteNodesWithGreaterRight {
    private static ListNode reverse(ListNode head) {
       ListNode prev=null,curr=head,next;
       while(curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       return prev;
    }
    public static ListNode deleteNodes(ListNode head) {
      if(head==null) return null;
      head=reverse(head);
      ListNode curr = head;
      ListNode maXNode=head;
      while(curr!=null&&curr.next!=null){
          if(curr.next.val<maXNode.val){
              curr.next=curr.next.next;
          }
          else {
              curr=curr.next;
              maXNode=curr;
          }
      }
      head=reverse(head);
      return head;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        head = deleteNodes(head);

        System.out.println("Modified List:");
        printList(head);
    }
}

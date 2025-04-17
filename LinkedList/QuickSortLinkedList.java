package com.kunal.Dsa.LinkedList;

public class QuickSortLinkedList {
    static ListNode getTail(ListNode head) {
       while(head!=null &&head.next!=null){
           head=head.next;
       }
       return head;
    }
    static ListNode[] partition(ListNode head, ListNode end) {
        ListNode pivot =end;
        ListNode prev =null,curr =head,tail=pivot;
        ListNode newHead=null,newEnd =tail;

        while(curr!=pivot){
            if(curr.val< pivot.val){
                if(newHead==null){
                    newHead=curr;
                }
                prev=curr;
                curr=curr.next;
            }
            else{
                if(prev!=null)
                    prev.next=curr.next;
                ListNode temp =curr.next;
                curr.next=null;
                tail.next=curr;
                tail=curr;
                curr=temp;
            }
        }
        if(newHead==null)
            newHead=pivot;

        newEnd=tail;
        return new ListNode[]{newHead,pivot,newEnd};
    }
    static ListNode quickSortRecur(ListNode head, ListNode end) {
      if(head==null|| head==end) return head;

      ListNode[] pr = partition(head,end);
      ListNode newHead = pr[0];
      ListNode pivot = pr[1];
      ListNode newEnd =pr[2];
      if(newHead!=pivot){
          ListNode temp =newHead;
          while(temp.next!=pivot){
              temp=temp.next;
          }
          temp.next=null;
          newHead=quickSortRecur(newHead,temp);
          temp =getTail(newHead);
          temp.next=pivot;
      }
      pivot.next=quickSortRecur(pivot.next,newEnd);
      return newHead;
    }

    public static ListNode quickSort(ListNode head) {
        return quickSortRecur(head, getTail(head));
    }

    // Utility function to print the list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);

        System.out.println("Original List:");
        printList(head);

        head = quickSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}

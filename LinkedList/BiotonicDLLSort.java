package com.kunal.Dsa.LinkedList;

public class BiotonicDLLSort {
    public static ListNode findPeak(ListNode head) {
    ListNode curr = head;
    while (curr!=null&&curr.next!=null&&curr.val<curr.next.val){
        curr=curr.next;
    }
    return curr;
    }

    public static ListNode reverse(ListNode head) {
       ListNode curr=head,temp=null;
       while(curr!=null){
           temp = curr.prev;
           curr.prev=curr.next;
           curr.next=temp;
           curr=curr.prev;
       }
       return (temp!=null)?temp.prev:head;
    }

    public static ListNode merge(ListNode first, ListNode second) {
       if(first==null) return second;
       if(second==null) return first;

       if(first.val<second.val){
           first.next=merge(first.next,second);
           first.next.prev=first;
           return first;
       }
       else {
           second.next=merge(first,second.next);
           second.next.prev=second;
           return second;
       }
    }

    public static ListNode sortBiotonicDLL(ListNode head) {
        if(head==null&&head.next==null) return null;
        ListNode peak = findPeak(head);

        if(peak==head) return reverse(head);
        if(peak.next==null) return head;

        ListNode second = peak.next;
        peak.next=null;

        if(second!=null) second.prev=null;
        second=reverse(second);
        return merge(head,second);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.prev = head;
        head.next.next = new ListNode(6);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode(8);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        System.out.println("Original Biotonic List:");
        printList(head);

        head = sortBiotonicDLL(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
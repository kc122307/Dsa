package com.kunal.Dsa.LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
      if(lists==null||lists.length==0) return null;

      PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);

        for (ListNode node:lists) {
            if(node!=null){
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            tail.next=min;
            tail=tail.next;

            if(min.next!=null){
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode result = mergeKLists(lists);
        printList(result);
    }
}

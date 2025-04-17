package com.kunal.Dsa.LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenMultiLevelList {
    public static ListNode flatten(ListNode head) {
      if(head==null) return null;
      Queue<ListNode> queue = new LinkedList<>();
      queue.offer(head);
      ListNode dummy = new ListNode(0);
      ListNode prev = dummy;
      while(!queue.isEmpty()){
        ListNode node = queue.poll();
        prev.next=node;
        prev=node;
        if(node.next!=null){
            queue.offer(node.next);
        }
        if(node.child!=null){
            queue.offer(node.child);
            node.child=null;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head.next.child = new ListNode(7);
        head.next.child.next = new ListNode(8);
        head.next.child.next.child = new ListNode(11);
        head.next.child.next.next = new ListNode(9);
        head.next.child.next.next.next = new ListNode(10);

        head.next.next.next.child = new ListNode(5);
        head.next.next.next.child.next = new ListNode(6);

        System.out.println("Flattened Linked List:");
        ListNode flattenedHead = flatten(head);
        printList(flattenedHead);
    }
}

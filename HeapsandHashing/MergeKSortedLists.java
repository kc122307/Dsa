package com.kunal.Dsa.HeapsandHashing;

import java.util.*;

public class MergeKSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Merge k sorted linked lists using a priority queue (min-heap)
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null|| lists.length==0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        for (ListNode node:lists) {
            if(node!=null){
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current =dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            current.next=node;
            current=current.next;

            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    // Helper function to build a linked list from an array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function to test
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {
                buildList(new int[]{1, 4, 5}),
                buildList(new int[]{1, 3, 4}),
                buildList(new int[]{2, 6})
        };

        ListNode merged = mergeKLists(lists);
        System.out.print("Merged List: ");
        printList(merged);
    }
}

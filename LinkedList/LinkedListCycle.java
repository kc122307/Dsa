package com.kunal.Dsa.LinkedList;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
      if(head==null||head.next==null) return false;
      ListNode slow = head;
      ListNode fast = head;
      while(fast!=null || fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
          if(slow==fast) return true;
      }
      return false;
    }
    public static ListNode createCyclicList(int[] arr, int pos) {
       if(arr.length==0) return null;
       ListNode head = new ListNode(arr[0]);
       ListNode curr = head;
       ListNode cycleNode = null;
        for (int i = 1; i < arr.length ; i++) {
            curr.next=new ListNode(arr[i]);
            curr=curr.next;
            if(i==pos){
                cycleNode= curr;
            }
        }
        if(pos!=-1){
            curr.next=cycleNode;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
        ListNode head = createCyclicList(arr, 1); // Cycle at index 1

        System.out.println(hasCycle(head)); // Output: true
    }
}

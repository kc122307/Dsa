package com.kunal.Dsa.LinkedList;

public class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode dummy = new ListNode(-1);
       ListNode current = dummy;
       while(list1!=null&&list2!=null){
           if(list1.val<=list2.val){
               current.next= list1;
               list1=list1.next;
           }
           else {
               current.next=list2;
               list2=list2.next;
           }
           current=current.next;
       }
       if(list1!=null) current.next=list1;
       if(list2!=null) current.next=list2;
       return dummy.next;
    }

    public static ListNode arrayToList(int[] arr) {
        if(arr.length==0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length ; i++) {
            curr.next= new ListNode(arr[i]);
            curr=curr.next;
        }
        return head;
    }
    public static void printList(ListNode head) {
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};

        ListNode list1 = arrayToList(arr1);
        ListNode list2 = arrayToList(arr2);

        System.out.println("Merged List:");
        ListNode mergedHead = mergeTwoLists(list1, list2);
        printList(mergedHead); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
    }
}

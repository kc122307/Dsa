package com.kunal.Dsa.LinkedList;

public class MultiplyLinkedLists {
    static long multiplyTwoLists(ListNode first, ListNode second) {
       long MOD=1000000007;
       long num1=0,num2=0;
       while(first!=null){
           num1=((num1*10)+first.val)%MOD;
           first=first.next;
       }
       while(second!=null){
           num2=((num2*10)+second.val)%MOD;
           second=second.next;
       }
       return (num1*num2)%MOD;
    }
    public static void main(String[] args) {
        // Create first list 9->4->6
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);

        // Create second list 8->4
        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(4);

        // Multiply lists and print result
        System.out.println(multiplyTwoLists(head1, head2)); // Output: 79464
    }
}


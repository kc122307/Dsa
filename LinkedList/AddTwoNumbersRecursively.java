package com.kunal.Dsa.LinkedList;

public class AddTwoNumbersRecursively {
    static class SumResult {
        ListNode node;
        int carry;
        SumResult(ListNode node,int carry){
            this.node=node;
            this.carry=carry;
        }
    }
    static int getLength(ListNode head) {
      int len =0;
      while(head!=null){
          len++;
          head=head.next;
      }
      return len;
    }
    static ListNode padZeros(ListNode head, int padding) {
        for (int i = 0; i < padding; i++) {
            ListNode temp =new ListNode(0);
            temp.next=head;
            head=temp;
         }
        return head;
    }
    static SumResult addHelper(ListNode l1, ListNode l2) {
      if(l1==null&&l2==null){
          return new SumResult(null,0);
      }
      SumResult nextSum = addHelper(l1.next,l2.next);
      int total = l1.val+l2.val+nextSum.carry;
      ListNode curr = new ListNode(total%10);
      curr.next= nextSum.node;
      return new SumResult(curr,total/10);
    }
    public static ListNode addLists(ListNode l1, ListNode l2) {
       int len1 = getLength(l1);
       int len2 = getLength(l2);
       if(len1>len2) l2=padZeros(l2,len1-len2);
       else if (len2>len1) l1 = padZeros(l1,len2-len1);

       SumResult result = addHelper(l1,l2);
       if(result.carry>0){
           ListNode head = new ListNode(result.carry);
           head.next=result.node;
           return head;
       }
       return result.node;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(4);
        num1.next = new ListNode(5);

        ListNode num2 = new ListNode(3);
        num2.next = new ListNode(4);
        num2.next.next = new ListNode(5);

        ListNode result = addLists(num1, num2);
        printList(result); // Output: 3 -> 9 -> 0
    }
}

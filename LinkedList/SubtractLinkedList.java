package com.kunal.Dsa.LinkedList;

public class SubtractLinkedList {
    static int getLength(ListNode head) {
       int count =0;
       while (head!=null){
           count++;
           head=head.next;
       }
       return count;
    }
    static int compare(ListNode l1, ListNode l2) {
     int len1= getLength(l1);
     int len2 = getLength(l2);

     if(len1!=len2){
         return len1>len2?1:-1;
     }

     while(l1!=null&&l2!=null){
         if(l1.val!=l2.val){
             return l1.val>l2.val ? 1 : -1;
         }
         l1=l1.next;
         l2=l2.next;
     }
     return 0;
    }
    static ListNode reverse(ListNode head) {
     ListNode prev =null;
     while(head!=null){
         ListNode next = head.next;
         head.next=prev;
         prev=head;
         head=next;
     }
     return prev;
    }
    static ListNode removeLeadingZeros(ListNode head) {
        while (head!=null&&head.val==0){
            head=head.next;
        }
        return head==null?new ListNode(0):head;
    }

    public static ListNode subtract(ListNode l1, ListNode l2) {
       if(l1==null) return null;
       if(l2==null) return l1;

       int cmp = compare(l1,l2);

       ListNode big = (cmp>=0)?l1:l2;
       ListNode small =(cmp>=0)?l2:l1;

       big = reverse(big);
       small= reverse(small);

       ListNode dummy = new ListNode(-1);
       ListNode curr= dummy;
       int borrow =0;

       while(big!=null){
           int diff = big.val-(small!=null ? small.val :0) -borrow;
           if(diff<0){
               borrow=1;
               diff+=10;
           }
           else{
               borrow=0;
           }
           curr.next=new ListNode(diff);
           curr=curr.next;

           big=big.next;
           if(small!=null) small=small.next;
       }
       return removeLeadingZeros(reverse(dummy.next));
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(0);

        ListNode l2 = new ListNode(1);

        System.out.print("Result: ");
        ListNode result = subtract(l1, l2);
        printList(result); // Output: 9 -> 9 -> 9
    }
}

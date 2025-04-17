package com.kunal.Dsa.LinkedList;

public class GetIntersectionNode {
    static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
       if(head1==null||head2==null) return null;
       ListNode node1 = head1;
       ListNode node2 = head2;
       while(node1!=node2){
           node1=(node1==null)?head2:node1.next;
           node2=(node2==null)?head1:node2.next;
       }
       return node1;
    }
    public static void main(String[] args) {
        // First linked list: 1 -> 2 -> 3 -> 6 -> 7
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(7);

        // Second linked list: 4 -> 5 -> 6 -> 7 (intersecting at node 6)
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = head1.next.next.next; // Linking to node 6

        ListNode intersectionPoint = getIntersectionNode(head1, head2);

        if (intersectionPoint == null)
            System.out.println("No Intersection (-1)");
        else
            System.out.println("Intersection at node with value: " + intersectionPoint.val);
    }
}


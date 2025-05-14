package com.kunal.Dsa.BinarySearchTree;

import java.util.Stack;

public class FlattenBST {
    TreeNode head = null; // New head of the flattened list

    public TreeNode flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current =root;
        TreeNode prev = null;
        while (current!=null||!stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();

            if(prev!=null){
                prev.left=null;
                prev.right=current;
            }
            else {
                head=current;
            }
            prev=current;
            current=current.right;
        }
        return head;
    }

    public void printList(TreeNode node) {
       while (node!=null){
           System.out.print(node.val+" ");
           node=node.right;
       }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        FlattenBST flattener = new FlattenBST();
        TreeNode newHead = flattener.flatten(root); // get the start of flattened list
        flattener.printList(newHead);               // Output: 2 3 4 5 6 7 8
    }
}

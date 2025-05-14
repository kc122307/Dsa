package com.kunal.Dsa.BinaryTrees;

public class BinaryTreeToDLL {
    TreeNode prev = null;
    TreeNode head = null;
    public void convertToDLL(TreeNode root) {
       if(root==null) return;
       convertToDLL(root.left);

       if(prev==null){
           head=root;
       }
       else{
           root.left=prev;
           prev.right=root;
       }
       prev = root;
       convertToDLL(root.right);
    }

    public void printDLLForward(TreeNode node) {
        while (node!=null){
            System.out.print(node.val+" ");
            if(node.right==null) break;
            node=node.right;
        }
        System.out.println();
    }

    public void printDLLBackward(TreeNode node) {
        while(node.right!=null){
            node=node.right;
        }
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.left;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        BinaryTreeToDLL converter = new BinaryTreeToDLL();
        converter.convertToDLL(root);

        System.out.println("Forward DLL:");
        converter.printDLLForward(converter.head);

        System.out.println("Backward DLL:");
        converter.printDLLBackward(converter.head);
    }
}

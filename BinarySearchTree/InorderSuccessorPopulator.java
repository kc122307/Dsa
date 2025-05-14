package com.kunal.Dsa.BinarySearchTree;


public class InorderSuccessorPopulator {
    private TreeNode prev =null;
    public void populateNext(TreeNode root) {
       if(root==null) return;

       populateNext(root.left);

       if(prev!=null){
           prev.next=root;
       }
       prev=root;

       populateNext(root.right);
    }
    public void printInorderWithNext(TreeNode root) {
        if(root==null) return;
        printInorderWithNext(root.left);
        System.out.println(root.val+"->"+(root.next!=null?root.next.val:-1));
        printInorderWithNext(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);

        InorderSuccessorPopulator isp = new InorderSuccessorPopulator();
        isp.populateNext(root);
        isp.printInorderWithNext(root);

    }
}

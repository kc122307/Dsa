package com.kunal.Dsa.BinarySearchTree;

public class LargestBSTInBinaryTree {
    static class NodeInfo {
        boolean isBST;
        int size;
        int min;
        int max;
        NodeInfo(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.max=max;
            this.min=min;
        }
    }
    private int maxBSTSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        postOrder(root);
        return maxBSTSize;
    }
    private NodeInfo postOrder(TreeNode node) {
        if(node==null) return new NodeInfo(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);

       NodeInfo left= postOrder(node.left);
       NodeInfo right= postOrder(node.right);

       if(left.isBST&&right.isBST&&node.val> left.max&&node.val<right.min){
           int size = 1+left.size+right.size;
           maxBSTSize=Math.max(size,maxBSTSize);
           return new NodeInfo(true,size,Math.min(left.min,node.val),Math.max(right.max,node.val));
       }
       else{
           return new NodeInfo(false,0,0,0);
       }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);  // This node violates BST property

        LargestBSTInBinaryTree solver = new LargestBSTInBinaryTree();
        System.out.println("Size of Largest BST is: " + solver.largestBSTSubtree(root));  // Output: 3
    }
}

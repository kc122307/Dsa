package com.kunal.Dsa.BinaryTrees;

public class IsBalancedTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!=-1;
    }

    private int checkHeight(TreeNode node) {
        if(node==null) return 0;

        int leftheight = checkHeight(node.left);
        if(leftheight==-1) return -1;

        int rightheight =checkHeight(node.right);
        if(rightheight==-1) return -1;

        if(Math.abs(leftheight-rightheight)>1) return -1;

        return Math.max(leftheight,rightheight)+1;
    }

    public static void main(String[] args) {
        IsBalancedTree tree = new IsBalancedTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println(tree.isBalanced(root));  // Output: false
    }
}

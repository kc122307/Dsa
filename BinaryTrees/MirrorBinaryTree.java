package com.kunal.Dsa.BinaryTrees;

public class MirrorBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode mirror(TreeNode root) {
       if(root==null) return null;

       TreeNode leftmirror = mirror(root.left);
       TreeNode rightmirror = mirror(root.right);

       root.left=rightmirror;
       root.right=leftmirror;

       return root;
    }

    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        MirrorBinaryTree solution = new MirrorBinaryTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        System.out.print("Inorder of original tree: ");
        solution.inorder(root);
        System.out.println();

        TreeNode mirrorRoot = solution.mirror(root);

        System.out.print("Inorder of mirror tree: ");
        solution.inorder(mirrorRoot);
        System.out.println();
    }
}

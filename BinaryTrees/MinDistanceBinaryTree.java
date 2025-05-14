package com.kunal.Dsa.BinaryTrees;

import com.sun.source.tree.Tree;

public class MinDistanceBinaryTree {
    static TreeNode findLCA(TreeNode root, int a, int b) {
        if(root==null) return null;
        if (root.val==a||root.val==b) return root;

        TreeNode left = findLCA(root.left,a,b);
        TreeNode right =findLCA(root.right,a,b);

        if(left!=null&&right!=null) return root;
        return left!=null?left:right;
    }

    static int findLevel(TreeNode root, int target, int level) {
        if(root==null) return -1;
        if(root.val==target) return level;

        int left = findLevel(root.left,target,level+1);
        if(left!=-1) return left;
        return findLevel(root.right,target,level+1);
    }

    static int findMinDistance(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root,a,b);
        int d1 = findLevel(lca,a,0);
        int d2 = findLevel(lca,b,0);
        return d1+d2;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(22);
        root.right = new TreeNode(33);
        root.left.left = new TreeNode(44);
        root.left.right = new TreeNode(55);
        root.right.left = new TreeNode(66);
        root.right.right = new TreeNode(77);

        int a = 77, b = 22;
        System.out.println("Minimum distance between " + a + " and " + b + " is: " + findMinDistance(root, a, b));
    }
}

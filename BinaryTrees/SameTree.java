package com.kunal.Dsa.BinaryTrees;

public class SameTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!= q.val) return false;

        return isSameTree(p.left,q.left )&& isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println("Are the trees the same? " + solution.isSameTree(p, q)); // true
    }
}

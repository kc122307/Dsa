package com.kunal.Dsa.BinaryTrees;

public class SubtreeChecker{
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(isSameTree(root,subRoot)) return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
       if(s==null&&t==null) return true;
       if(s==null||t==null||s.val!=t.val) return false;

       return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }

    public static void main(String[] args) {
        SubtreeChecker checker = new SubtreeChecker();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(checker.isSubtree(root, subRoot)); // Output: true
    }
}

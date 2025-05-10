package com.kunal.Dsa.BinaryTrees;


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class ConvertToSumTree {
    public int convert(TreeNode root) {
       if(root==null) return 0;
       if(root.left==null&&root.right==null){
           int temp = root.val;
           root.val=0;
           return temp;
       }

       int leftSum = convert(root.left);
       int rightSum = convert(root.right);

       int oldVal = root.val;
       root.val=leftSum+rightSum;

       return oldVal+root.val;
    }

    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        ConvertToSumTree tree = new ConvertToSumTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        tree.convert(root);

        System.out.print("Inorder of converted tree: ");
        tree.inorder(root);  // Output: 0 4 0 20 0 12 0
    }
}

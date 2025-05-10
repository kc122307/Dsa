package com.kunal.Dsa.BinaryTrees;


public class LCABinaryTree {
    public static TreeNode findLCA(TreeNode root, int n1, int n2){
       if(root==null) return null;
       if(root.val==n1||root.val==n2) return root;

       TreeNode leftside = findLCA(root.left,n1,n2);
       TreeNode rightside = findLCA(root.right,n1,n2);

       if(leftside!=null&&rightside!=null) return root;

       return (leftside!=null)?leftside:rightside;
    }
    public static void main(String[] args) {
        /*
                Tree Structure:
                       5
                      /
                     2
                    / \
                   3   4
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        int n1 = 3, n2 = 4;
        TreeNode lca = findLCA(root, n1, n2);

        if (lca != null)
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.val);
        else
            System.out.println("LCA does not exist.");
    }
}

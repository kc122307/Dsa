package com.kunal.Dsa.BinarySearchTree;

public class SearchBST {
    public static boolean searchBST(TreeNode root, int key) {
       if(root==null) return false;
       if(root.val==key) return true;
       if(key< root.val) return searchBST(root.left,key);
       return searchBST(root.right,key);
    }
    public static void main(String[] args) {
        // Build sample BST: [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Example 1: search for 8
        int key1 = 8;
        System.out.println("Search for " + key1 + ": " + searchBST(root, key1)); // true

        // Example 2: search for 14
        int key2 = 14;
        System.out.println("Search for " + key2 + ": " + searchBST(root, key2)); // false
    }
}

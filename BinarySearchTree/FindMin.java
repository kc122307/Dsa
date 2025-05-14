package com.kunal.Dsa.BinarySearchTree;

public class FindMin {
    public static int findMin(TreeNode root) {
       if(root==null){
           throw new IllegalArgumentException("Tree is Empty");
       }
       while(root.left!=null){
           root=root.left;
       }
       return root.val;
    }
    public static void main(String[] args) {
        // Example 1: [5, 4, 6, 3, N, N, 7, 1]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(1);

        System.out.println("Minimum element in BST (Example 1): " + findMin(root1)); // Output: 1

        // Example 2: [10, 5, 20, 2]
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(20);
        root2.left.left = new TreeNode(2);

        System.out.println("Minimum element in BST (Example 2): " + findMin(root2)); // Output: 2

        // Example 3: [10, N, 10, N, 11]
        TreeNode root3 = new TreeNode(10);
        root3.right = new TreeNode(10);
        root3.right.right = new TreeNode(11);

        System.out.println("Minimum element in BST (Example 3): " + findMin(root3)); // Output: 10
    }
}

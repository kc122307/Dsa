package com.kunal.Dsa.BinarySearchTree;

public class KthSmallestInBST {
    private int count=0;
    private int result =-1;
    public int kthSmallest(TreeNode root, int k) {
        result=-1;
        count=0;
        inOrder(root,k);
        return result;
    }
    private void inOrder(TreeNode node, int k) {
        if(node==null) return;

        inOrder(node.left,k);
        count++;
        if(count==k){
            result= node.val;
            return;
        }
        inOrder(node.right,k);
    }
    public static void main(String[] args) {
        // Example 1: [3,1,4,null,2], k = 1 => Output: 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        // Example 2: [5,3,6,2,4,null,null,1], k = 3 => Output: 3
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        KthSmallestInBST solution = new KthSmallestInBST();

        System.out.println("Example 1: " + solution.kthSmallest(root1, 1)); // Output: 1
        System.out.println("Example 2: " + solution.kthSmallest(root2, 3)); // Output: 3
    }
}

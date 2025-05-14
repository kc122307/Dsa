package com.kunal.Dsa.BinarySearchTree;

public class KthLargestInBST {
    static  int count =0;
    static int result =-1;
    public static void kthLargest(TreeNode root, int k) {
       if(root==null||count>=k){
           return;
       }
       kthLargest(root.right,k);
       count++;

       if(count==k){
           result=root.val;
           return;
       }
       kthLargest(root.right,k);
    }

    public static int findKthLargest(TreeNode root, int k) {
        count=0;
        result=-1;
        kthLargest(root,k);
        return result;
    }
    public static void main(String[] args) {
        // Example: BST = [4, 2, 9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        int k = 2;
        System.out.println("Kth Largest Element: " + findKthLargest(root, k)); // Output: 4
    }
}

package com.kunal.Dsa.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {
    static int index=0;
    public static void storeInorder(TreeNode root, List<Integer> list) {
        if(root==null) return;
        storeInorder(root.left,list);
        list.add(root.val);
        storeInorder(root.right,list);
    }
    public static void arrayToBST(TreeNode root, List<Integer> list) {
        if (root == null) return;
        arrayToBST(root.left,list);
        root.val=list.get(index++);
        arrayToBST(root.right,list);
    }
    public static void binaryTreeToBST(TreeNode root) {
       List<Integer> values = new ArrayList<>();
       storeInorder(root,values);
       Collections.sort(values);
       index=0;
       arrayToBST(root,values);
    }
    public static void printInorder(TreeNode root) {
        if(root==null) return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        // Example: Create binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        binaryTreeToBST(root);

        // Print inorder of the converted BST
        printInorder(root);  // Output: 1 2 3 4
    }
}

package com.kunal.Dsa.BinarySearchTree;

import java.util.Arrays;

public class ReplaceWithLeastGreater {
    static TreeNode insert(TreeNode root, int key, int[] successor) {
       if (root==null) {
           return new TreeNode(key);
       }
       if(key<root.val){
           successor[0]=root.val;
           root.left=insert(root.left,key,successor);
       }
       else {
           root.right=insert(root.right,key,successor);
       }
       return root;
    }
    static void replaceWithLeastGreater(int[] arr) {
        TreeNode root = null;
        for (int i = arr.length-1; i >=0 ; i--) {
            int [] succesor = new int[1];
            succesor[0]=-1;
            root= insert(root,arr[i],succesor);
            arr[i]=succesor[0];
        }
    }
    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92,
                43, 3, 91, 93, 25, 80, 28};

        replaceWithLeastGreater(arr);

        System.out.println("Output:");
        System.out.println(Arrays.toString(arr));
    }
}

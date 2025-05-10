package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public List<Integer> zigZagTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root==null) return result;

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       boolean lefttoright = true;

       while(!queue.isEmpty()){
           int size = queue.size();
           LinkedList<Integer> level = new LinkedList<>();
           for (int i = 0; i <size ; i++) {
               TreeNode node = queue.poll();
               if(lefttoright){
                   level.addLast(node.val);
               }
               else {
                   level.addFirst(node.val);
               }
               if(node.left!=null) queue.offer(node.left);
               if(node.right!=null) queue.offer(node.right);
           }
           result.addAll(level);
           lefttoright=!lefttoright;
       }
       return result;
    }
    public static void main(String[] args) {
        ZigZagTraversal solution = new ZigZagTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> output = solution.zigZagTraversal(root);
        System.out.println(output);  // Output: [1, 3, 2, 4, 5, 6, 7]
    }
}

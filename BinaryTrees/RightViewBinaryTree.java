package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public List<Integer> rightView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root==null) return result;

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       while(!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               if(i==0) result.add(node.val);
               if(node.left!=null) queue.offer(node.right);
               if(node.right!=null) queue.offer(node.left);
           }
       }
       return result;
    }
    public static void main(String[] args) {
        RightViewBinaryTree solution = new RightViewBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> output = solution.rightView(root);
        System.out.println(output);  // Output: [1, 3, 5]
    }
}

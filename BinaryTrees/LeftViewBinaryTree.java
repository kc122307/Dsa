package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i==0) result.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LeftViewBinaryTree solution = new LeftViewBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> output = solution.leftView(root);
        System.out.println(output);  // Output: [1, 2, 4]
    }
}

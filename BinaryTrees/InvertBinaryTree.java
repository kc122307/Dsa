package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode temp = root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);

        return root;
    }

    public List<Integer> levelOrder(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root==null) return result;

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()){
           TreeNode currnode = queue.poll();
           result.add(currnode.val);

           if(currnode.left!=null) queue.offer(currnode.left);
           if(currnode.right!=null) queue.offer(currnode.right);

       }
       return result;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = solution.invertTree(root);
        List<Integer> list = solution.levelOrder(inverted);
        System.out.println(list);
    }
}

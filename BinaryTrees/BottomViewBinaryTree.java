package com.kunal.Dsa.BinaryTrees;

import java.util.*;

// Definition for binary tree node


public class BottomViewBinaryTree {

    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }

    // Method to return bottom view
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            map.put(hd, node.val);

            if(node.left!=null) queue.offer(new Pair(node.left,hd-1));
            if(node.right!=null) queue.offer(new Pair(node.right,hd+1));
        }
        for (int val:map.values()) {
            result.add(val);
        }
        return result;
    }

    // Test method
    public static void main(String[] args) {
        // Build the tree:
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        // Call bottom view
        List<Integer> bottom = bottomView(root);
        System.out.println("Bottom View: " + bottom);  // Expected: [40, 20, 60, 30]
    }
}

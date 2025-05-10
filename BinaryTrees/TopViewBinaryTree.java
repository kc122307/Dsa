package com.kunal.Dsa.BinaryTrees;

import java.util.*;

class Pair {
    TreeNode node;
    int hd;
    Pair(TreeNode n , int hd){
        this.node=n;
        this.hd =hd;
    }
}
public class TopViewBinaryTree {
    public List<Integer> topView(TreeNode root) {
        List<Integer> resullt = new ArrayList<>();
        if(root==null) return resullt;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;
            if(!map.containsKey(hd)){
                map.put(hd, node.val);
            }
            if(node.left!=null) queue.offer(new Pair(node.left,hd-1));
            if(node.right!=null) queue.offer(new Pair(node.right,hd+1));
        }
        for (int val:map.values()) {
            resullt.add(val);
        }
        return resullt;
    }
    // For demonstration/testing
    public static void main(String[] args) {
        TopViewBinaryTree tree = new TopViewBinaryTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);


        List<Integer> topView = tree.topView(root);
        System.out.println("Top view: " + topView); // Output: [2, 1, 3, 6]
    }
}

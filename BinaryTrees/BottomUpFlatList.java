package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomUpFlatList {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public static List<Integer> levelOrderBottomFlat(TreeNode root) {
       List<List<Integer>> levels = new ArrayList<>();
       if(root==null) return new ArrayList<>();

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()){
           int size = queue.size();
           List<Integer> currentlevel = new ArrayList<>();

           for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               currentlevel.add(node.val);

               if(node.left!=null) queue.offer(node.left);
               if(node.right!=null) queue.offer(node.right);
           }
           levels.add(0,currentlevel);
       }
       List<Integer> flatlist = new ArrayList<>();
        for (List<Integer> level:levels) {
            flatlist.addAll(level);
        }
        return flatlist;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        List<Integer> result = levelOrderBottomFlat(root);
        System.out.println(result); // Output: [3, 2, 1]
    }
}

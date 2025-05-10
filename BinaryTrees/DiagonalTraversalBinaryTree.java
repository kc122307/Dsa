package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversalBinaryTree {
    public static void diagonalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        traverse(root,0,map);
        for (List<Integer> diaglist: map.values()) {
            for (int val:diaglist) {
                System.out.print(val+" ");
            }
        }
    }
    private static void traverse(TreeNode node, int diagonal, Map<Integer, List<Integer>> map) {
       if(node==null) return;
       map.computeIfAbsent(diagonal,k->new ArrayList<>()).add(node.val);

       traverse(node.left,diagonal+1,map);
       traverse(node.right,diagonal,map);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        System.out.print("Diagonal Traversal: ");
        diagonalTraversal(root);  // Output: 8 10 14 3 6 7 13 1 4
    }
}

package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtrees {
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> result=new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }
    private String serialize(TreeNode node) {
        if(node==null) return "#";

        String left= serialize(node.left);
        String right = serialize(node.right);
        String serial = node.val+ " "+left+" "+right;

        map.put(serial,map.getOrDefault(serial,0)+1);
        if(map.get(serial)==2){
            result.add(node);
        }
        return serial;
    }

    public static void preorder(TreeNode root) {
        if(root==null) return;
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(6);

        DuplicateSubtrees solution = new DuplicateSubtrees();
        List<TreeNode> duplicates = solution.findDuplicateSubtrees(root);

        System.out.println("Duplicate Subtrees (Preorder):");
        for (TreeNode node : duplicates) {
            preorder(node);
            System.out.println();
        }
    }
}

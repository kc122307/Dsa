package com.kunal.Dsa.BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class DuplicateSubtreeChecker {
    static boolean foundDuplicate = false;

    public static int dupSub(TreeNode root) {
       foundDuplicate=false;
       Map<String,Integer> map = new HashMap<>();
       serialize(root,map);
       return foundDuplicate?1:0;
    }

    private static String serialize(TreeNode node, Map<String, Integer> map) {
       if(node==null) return "#";

       String left = serialize(node.left,map);
       String right =serialize(node.right,map);

       String serial = left+" "+node.val+" "+right;

       if(!serial.equals("#,#,#")){
           map.put(serial,map.getOrDefault(serial,0)+1);
           if(map.get(serial)==2){
               foundDuplicate=true;
           }
       }
       return serial;
    }
    public static TreeNode example1Tree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        return root;
    }

    public static TreeNode example2Tree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Output for Example 1: " + dupSub(example1Tree())); // 1
        System.out.println("Output for Example 2: " + dupSub(example2Tree())); // 0
    }
}

package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        if(root==null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr==null) result.add("null");
            else{
                result.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        int i = result.size()-1;

        while(i>=0&&result.get(i).equals("null")){
            result.remove(i--);
        }
        return "["+ String.join(",",result)+"]";
    }
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;

        String[] nodes = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;

        while(!queue.isEmpty()&&i<nodes.length){
            TreeNode curr = queue.poll();

            if(!nodes[i].equals("null")){
                curr.left= new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;

            if(!nodes[i].equals("null")&&i<nodes.length){
                curr.right=new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Example tree: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized); // [1,2,3,null,null,4,5]

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Serialized again after deserialization: " + codec.serialize(deserialized));
    }
}

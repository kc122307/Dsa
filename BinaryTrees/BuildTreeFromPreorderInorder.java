package com.kunal.Dsa.BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BuildTreeFromPreorderInorder {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private int prefixIndex=0;
    private Map<Integer,Integer> inordermap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inordermap.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if(left>right) return null;
        int rootValue = preorder[prefixIndex++];

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inordermap.get(rootValue);

        root.left= helper(preorder,left,inorderIndex-1);
        root.right=helper(preorder,inorderIndex+1,right);

        return root;
    }

    public void printLevelOrder(TreeNode root) {
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print((node!=null?node.val :"N")+ " ");

            if(node!=null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }


    public static void main(String[] args) {
        BuildTreeFromPreorderInorder solution = new BuildTreeFromPreorderInorder();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.print("Inorder of constructed tree: ");
        solution.printLevelOrder(root);  // Output: 3 9 20 null null 15 7
    }
}

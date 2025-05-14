package com.kunal.Dsa.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    private void inorder(TreeNode root, List<TreeNode> nodes) {
       if(root==null) return;
       inorder(root.left,nodes);
       nodes.add(root);
       inorder(root.right,nodes);
    }

    private TreeNode buildBalancedTree(List<TreeNode> nodes, int start, int end) {
        if(start>end) return null;

        int mid =start+(end-start)/2;
        TreeNode node = nodes.get(mid);

        node.left=buildBalancedTree(nodes,start,mid-1);
        node.right=buildBalancedTree(nodes,mid+1,end);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
       if(root==null) return null;
       List<TreeNode> nodes = new ArrayList<>();
       inorder(root,nodes);
       return buildBalancedTree(nodes,0, nodes.size()-1);
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        // Example: Unbalanced BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(30);

        BalanceBST balancer = new BalanceBST();
        System.out.print("Preorder of Original BST: ");
        balancer.preorder(root);
        System.out.println();

        TreeNode balanced = balancer.balanceBST(root);
        System.out.print("Preorder of Balanced BST: ");
        balancer.preorder(balanced);
        // Expected output: "Preorder of Balanced BST: 5 0 1 20 10 30"
    }
}
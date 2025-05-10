package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    private boolean isLeaf(TreeNode node) {
       return node.left==null&&node.right==null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
       while(node!=null){
           if(!isLeaf(node)) result.add(node.val);
           node=(node.left!=null)?node.left:node.right;
       }
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while(node!=null){
            if(!isLeaf(node)) stack.push(node.val);
            node=(node!=null)?node.right:node.left;
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
    }
    private void addLeaves(TreeNode node, List<Integer> result) {
       if(isLeaf(node)){
           result.add(node.val);
       }

       if(node.left!=null) addLeaves(node.left,result);
       if(node.right!=null) addLeaves(node.right,result);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root==null) return result;

       if(!isLeaf(root)) result.add(root.val);
       addLeftBoundary(root.left,result);
       addLeaves(root,result);
       addRightBoundary(root.right,result);

       return result;
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.right = new TreeNode(7);

        BoundaryTraversal bt = new BoundaryTraversal();
        List<Integer> boundary = bt.boundaryOfBinaryTree(root);
        System.out.println("Boundary Traversal: " + boundary);
    }

}

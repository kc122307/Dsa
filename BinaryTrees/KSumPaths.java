package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class KSumPaths {
    public void printKSumPaths(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        findPaths(root,k,path);
    }
    private void findPaths(TreeNode node, int k, List<Integer> path) {
       if(node==null) return;
       path.add(node.val);

       findPaths(node.left,k,path);
       findPaths(node.right,k,path);

       int sum =0;

        for (int i = path.size()-1; i >=0 ; i--) {
            sum+=path.get(i);
            if(sum==k){
                printPath(path,i);
            }
        }
        path.remove(path.size()-1);
    }

    private void printPath(List<Integer> path, int start) {
        for (int i = start; i < path.size() ; i++) {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        int k = 5;
        KSumPaths solver = new KSumPaths();
        System.out.println("Paths summing to " + k + ":");
        solver.printKSumPaths(root, k);
    }
}

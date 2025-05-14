package com.kunal.Dsa.BinarySearchTree;

public class DeadEndInBST {
    public static boolean hasDeadEnd(TreeNode root) {
        return checkDeadEnd(root,1,Integer.MAX_VALUE);
    }
    private static boolean checkDeadEnd(TreeNode node, int min, int max) {
        if(node==null) return false;
        if(min==max) return true;

        return checkDeadEnd(node.left,min,node.val-1)||checkDeadEnd(node.right, node.val+1,max);
    }
    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);

        System.out.println("Dead End Present: " + (hasDeadEnd(root) ? "Yes" : "No"));

        // Example 2
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(10);
        root2.left.left = new TreeNode(2);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(13);

        System.out.println("Dead End Present: " + (hasDeadEnd(root2) ? "Yes" : "No"));
    }
}

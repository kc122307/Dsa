package com.kunal.Dsa.BinaryTrees;

public class TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int maxDiameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode node) {
       if (node==null) return -1;
       int leftHeight = dfs(node.left);
       int rightHeight = dfs(node.right);

       int DiameterAtNode = leftHeight+rightHeight+2;
       maxDiameter=Math.max(DiameterAtNode,maxDiameter);
       return 1+Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args) {
        TreeDiameter solution = new TreeDiameter();

        // Example 1: [1, 2, 3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root1)); // Output: 2

        // Example 2: [5, 8, 6, 3, 7, 9]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.right = new TreeNode(9);

        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root2)); // Output: 4
    }
}

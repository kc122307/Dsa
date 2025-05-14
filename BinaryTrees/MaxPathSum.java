package com.kunal.Dsa.BinaryTrees;

public class MaxPathSum {
    static int maxSum ;

    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if(node==null) return 0;

        int leftGain = Math.max(dfs(node.left),0);
        int rightGain = Math.max(dfs(node.right),0);

        int currentMaxPath = node.val+leftGain+rightGain;

        maxSum=Math.max(currentMaxPath,maxSum);

        return node.val+Math.max(leftGain,rightGain);
    }
    public static void main(String[] args) {
        // Example 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        // Example 2:
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        MaxPathSum solution = new MaxPathSum();

        System.out.println("Max Path Sum (Example 1): " + solution.maxPathSum(root1)); // Output: 6
        System.out.println("Max Path Sum (Example 2): " + solution.maxPathSum(root2)); // Output: 42
    }
}

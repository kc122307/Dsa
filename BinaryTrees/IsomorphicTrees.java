package com.kunal.Dsa.BinaryTrees;

public class IsomorphicTrees {
    public boolean isIsomorphic(TreeNode root1, TreeNode root2) {
       if(root1==null&&root2==null) return true;
       if(root1==null||root2==null) return false;
       if(root1.val!=root2.val) return false;

       boolean flip = isIsomorphic(root1.left,root2.right)&&isIsomorphic(root1.right,root2.left);
       boolean noflip = isIsomorphic(root1.left,root2.left)&&isIsomorphic(root1.right,root2.right);

       return flip||noflip;
    }
    public static void main(String[] args) {
        // First Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        // Second Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(4);

        IsomorphicTrees solution = new IsomorphicTrees();
        boolean result = solution.isIsomorphic(root1, root2);

        System.out.println("Are the trees isomorphic? " + result); // Expected: true
    }
}

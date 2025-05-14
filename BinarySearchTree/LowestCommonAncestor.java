package com.kunal.Dsa.BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left, right,next;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val&&q.val> root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if (p.val< root.val&&q.val< root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        // Manually build BST from [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Set p and q
        TreeNode p = root.left;         // Node with value 2
        TreeNode q = root.right;        // Node with value 8

        // Find LCA
        TreeNode lca = lowestCommonAncestor(root, p, q);

        // Output the result
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}

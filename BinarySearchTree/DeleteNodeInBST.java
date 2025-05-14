package com.kunal.Dsa.BinarySearchTree;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key< root.val){
            root.left=deleteNode(root.left,key);
        }
        else if (key> root.val) {
            root.right=deleteNode(root.right,key);
        }
        else {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            TreeNode succesor = getMin(root.right);
            root.val=succesor.val;
            root.right=deleteNode(root.right, succesor.val);
        }
        return root;
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left!=null) node=node.left;
        return node;
    }

    public static void main(String[] args) {
        /*
        Input: [5,3,6,2,4,null,7], key = 3
        Output: [5,4,6,2,null,null,7] (or other valid BST)
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        DeleteNodeInBST solution = new DeleteNodeInBST();
        System.out.println("Before deletion:");
        solution.inOrder(root);

        root = solution.deleteNode(root, 3);

        System.out.println("\nAfter deletion of 3:");
        solution.inOrder(root);
    }
}

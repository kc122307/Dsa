package com.kunal.Dsa.BinarySearchTree;

import java.util.*;

public class MergeTwoBSTs {

    // Inorder traversal to get sorted elements
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Merge two sorted lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }
        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));
        return merged;
    }

    // Build balanced BST from sorted list
    private TreeNode buildBalancedBST(List<Integer> sorted, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left = buildBalancedBST(sorted, start, mid - 1);
        root.right = buildBalancedBST(sorted, mid + 1, end);
        return root;
    }

    // Merge two BSTs
    public TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> merged = mergeSortedLists(list1, list2);
        return buildBalancedBST(merged, 0, merged.size() - 1);
    }

    // Preorder traversal for verification
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        // Tree 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(20);

        // Tree 2
        TreeNode root2 = new TreeNode(15);
        root2.left = new TreeNode(12);
        root2.right = new TreeNode(18);

        MergeTwoBSTs merger = new MergeTwoBSTs();
        TreeNode mergedRoot = merger.mergeBSTs(root1, root2);

        System.out.print("Preorder of Merged Balanced BST: ");
        merger.preorder(mergedRoot);
    }
}

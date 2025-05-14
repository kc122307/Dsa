package com.kunal.Dsa.BinarySearchTree;

public class CountInRange {
    public int countInRange(TreeNode root, int l, int h) {
       if(root==null) return 0;

       if(root.val<l){
           return countInRange(root.right,l,h);
       }
       else if(root.val>h){
           return countInRange(root.left,l,h);
       }
       return 1+countInRange(root.left,l,h)+countInRange(root.right,l,h);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(100);

        CountInRange counter = new CountInRange();

        System.out.println("Count [5, 45]: " + counter.countInRange(root, 5, 45));     // Output: 3
        System.out.println("Count [10, 100]: " + counter.countInRange(root, 10, 100)); // Output: 4
        System.out.println("Count [23, 95]: " + counter.countInRange(root, 23, 95));   // Output: 2 (40 and 50)
    }
}

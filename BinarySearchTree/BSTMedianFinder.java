package com.kunal.Dsa.BinarySearchTree;

public class BSTMedianFinder {
    private int countNodes(TreeNode root) {
       if(root==null) return 0;
       return 1+countNodes(root.left)+countNodes(root.right);
    }
    private void inorder(TreeNode root, int[] count, int target1, int target2, double[] result) {
       if(root==null) return;
       inorder(root.left,count,target1,target2,result);

       count[0]++;
       if(count[0]==target1) result[0]+= root.val;;
       if(target1!=target2&&count[0]==target2) result[0]+=root.val;

       inorder(root.right,count,target1,target2,result);
    }

    public double findMedian(TreeNode root) {
        int n =countNodes(root);
        int [] count = new int[1];
        double [] result = new double[1];

        if(n%2==1) {
            inorder(root,count,(n+1)/2,(n+1)/2,result);
            return result[0];
        }
        else{
            inorder(root,count,n/2,(n+1)/2,result);
            return result[0]/2.0;
        }
    }
    public static void main(String[] args) {
        BSTMedianFinder finder = new BSTMedianFinder();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("Median of BST is: " + finder.findMedian(root));  // Output: 6.0
    }
}

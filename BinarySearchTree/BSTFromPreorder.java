package com.kunal.Dsa.BinarySearchTree;

public class BSTFromPreorder {
    static int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int min, int max) {
       if(index>=preorder.length){
           return null;
       }
       int val = preorder[index];

       if(val>max||val<min){
           return null;
       }
       TreeNode node = new TreeNode(val);
       index++;

       node.left= build(preorder,min,val-1);
       node.right=build(preorder,val+1,max);

       return node;
    }
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        BSTFromPreorder bstBuilder = new BSTFromPreorder();
        int[] preorder = {40, 30, 35, 80, 100};
        TreeNode root = bstBuilder.bstFromPreorder(preorder);
        bstBuilder.postOrder(root);
    }
}

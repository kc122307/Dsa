package com.kunal.Dsa.BinaryTrees;

public class LeafLevelChecker {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public boolean checkLeafLevel(TreeNode root) {
        return checkLeafLevelDFS(root,0,new int[]{-1});
    }
    private boolean checkLeafLevelDFS(TreeNode node, int level, int[] leafLevel) {
       if(node==null) return true;
       if(node.left==null&&node.right==null){
           if(leafLevel[0]==-1){
               leafLevel[0]=level;
           }
           else if (leafLevel[0]!=level) {
               return false;
           }
           return true;
       }
       return checkLeafLevelDFS(node.left,level+1,leafLevel)&&checkLeafLevelDFS(node.right,level+1,leafLevel);
    }
    public static void main(String[] args) {
        LeafLevelChecker checker = new LeafLevelChecker();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(checker.checkLeafLevel(root1)); // true

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.left = new TreeNode(10);
        root2.left.right = new TreeNode(15);
        System.out.println(checker.checkLeafLevel(root2)); // false

        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(1);
        System.out.println(checker.checkLeafLevel(root3)); // true
    }
}

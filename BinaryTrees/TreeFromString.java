package com.kunal.Dsa.BinaryTrees;

public class TreeFromString {
    static int index =0;
    public static TreeNode str2tree(String s) {
        if(s==null||s.length()==0) return null;
        return construct(s);
    }
    private static TreeNode construct(String s) {
       if(index>=s.length()) return null;

       int sign =1;
       if(s.charAt(index)=='-'){
           sign=-1;
           index++;
       }

       int num=0;
       while(index<s.length()&&Character.isDigit(s.charAt(index))){
           num=num*10+(s.charAt(index)-'0');
           index++;
       }
        TreeNode node = new TreeNode(num*sign);
       if(index<s.length()&&s.charAt(index)=='('){
           index++;
           node.left=construct(s);
           index++;
       }
       if(index<s.length()&&s.charAt(index)=='('){
           index++;
           node.right=construct(s);
           index++;
       }
       return node;
    }
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        String input1 = "1(2)(3)";
        String input2 = "4(2(3)(1))(6(5))";

        index = 0;
        TreeNode root1 = str2tree(input1);
        System.out.print("Preorder of Tree 1: ");
        preorder(root1); // Output: 1 2 3

        System.out.println();

        index = 0;
        TreeNode root2 = str2tree(input2);
        System.out.print("Preorder of Tree 2: ");
        preorder(root2); // Output: 4 2 3 1 6 5
    }
}

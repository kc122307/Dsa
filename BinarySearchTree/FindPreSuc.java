package com.kunal.Dsa.BinarySearchTree;

public class FindPreSuc {
    static TreeNode predeccesor,sucessor;
    public static void findPreSuc(TreeNode root, int key) {
       predeccesor=null;
       sucessor=null;
       TreeNode curr= root;
       while(curr!=null){
           if(curr.val==key){
               if(curr.left!=null){
                   TreeNode temp= curr.left;
                   while(temp.right!=null){
                       temp = temp.right;
                   }
                   predeccesor= temp;
               }
               if(curr.right!=null){
                   TreeNode temp = curr.right;
                   while (temp.left!=null){
                       temp=temp.left;
                   }
                   sucessor=temp;
               }
               break;
           }
           if(key< curr.val){
               sucessor=curr;
               curr=curr.left;
           }
           else {
               predeccesor=curr;
               curr=curr.right;
           }
       }
    }
    public static void main(String[] args) {
        // Example BST: [8, 1, 9, null, 4, null, 10, 3]
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.right = new TreeNode(10);

        int key = 8;
        findPreSuc(root, key);
        System.out.println("Predecessor: " + (predeccesor != null ? predeccesor.val : -1));
        System.out.println("Successor: " + (sucessor != null ? sucessor.val : -1));
    }
}

package com.kunal.Dsa.BinaryTrees;

public class KthAncestorFinder {

    static class KthAncestor {
        private int k;
        private int ancestor = -1;

        public TreeNode findKthAncestor(TreeNode root, int target, int k) {
            this.k = k;
            dfs(root,target);
            return ancestor==-1?null:new TreeNode(ancestor);
        }

        private TreeNode dfs(TreeNode root, int target) {
           if(root==null) return null;
           if(root.val==target) return root;

           TreeNode left = dfs(root.left,target);
           TreeNode right = dfs(root.right,target);

           if(left!=null||right!=null){
               k--;
               if(k==0&&ancestor==-1){
                   ancestor=root.val;
               }
               return root;
           }
           return null;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            int node = 5;
            int k = 2;

            KthAncestor obj = new KthAncestor();
            TreeNode result = obj.findKthAncestor(root, node, k);

            if (result != null)
                System.out.println(k + "th ancestor of node " + node + " is: " + result.val);
            else
                System.out.println(k + "th ancestor of node " + node + " doesn't exist");
        }
    }
}

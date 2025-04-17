package com.kunal.Dsa.StacksandQueues;

public class LongestValidParentheses {
    public static int findMaxLength(String s) {
       int left=0,right=0,maxlen=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') left++;
            else right++;

            if(left==right){
                maxlen= Math.max(maxlen,2*right);
            }
            else if (right>left) {
                left=right=0;
            }
        }

        left=right=0;

        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i)==')') right++;
            else left++;

            if(left==right){
                maxlen=Math.max(maxlen,2*left);
            }
            else if(left>right){
                left=right=0;
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength("((()"));      // Output: 2
        System.out.println(findMaxLength(")()())"));    // Output: 4
        System.out.println(findMaxLength("()(()))))")); // Output: 6
    }
}

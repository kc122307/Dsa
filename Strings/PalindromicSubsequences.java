package com.kunal.Dsa.Strings;

public class PalindromicSubsequences {
    public static int countPalindromicSubsequences(String s) {
        int n =s.length();
        int dp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
           dp[i][i]=1;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n-length ; i++) {
                int j= length+i-1;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
                }
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("abcd")); // Output: 4
        System.out.println(countPalindromicSubsequences("aab"));  // Output: 4
        System.out.println(countPalindromicSubsequences("b"));    // Output: 1
    }
}

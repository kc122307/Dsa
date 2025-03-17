package com.kunal.Dsa.Strings;

public class WildcardMatching {
    public static boolean match(String wild, String pattern) {
       int m =wild.length(),n=pattern.length();
       boolean [][] dp = new boolean[m+1][n+1];
       dp[0][0]=true;
        for (int i = 1; i < m+1; i++) {
            if(wild.charAt(i-1)=='*'){
                dp[i][0]=dp[i-1][0];
            }
        }
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                char wc= wild.charAt(i-1);
                char pc = pattern.charAt(j-1);
                if(wc==pc||wc=='?'){
                    dp[i][j]=dp[i-1][j-1];
                } else if (wc=='*') {
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        System.out.println(match("ge*ks", "geeks")); // Output: true
        System.out.println(match("ge?ks*", "geeksforgeeks")); // Output: true
        System.out.println(match("g*ks", "geeks")); // Output: true
        System.out.println(match("ge?ks", "geeksxyz")); // Output: false
    }
}

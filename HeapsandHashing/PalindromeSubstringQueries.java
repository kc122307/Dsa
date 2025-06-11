package com.kunal.Dsa.HeapsandHashing;

public class PalindromeSubstringQueries {
    public static boolean[][] preprocess(String str) {
        int n =str.length();
        boolean[][]dp = new boolean[n][n];

        for (int i = 0; i <n ; i++) {
            dp[i][i]= true;
        }

        for (int i = 0; i < n-1; i++) {
            dp[i][i+1]=(str.charAt(i)==str.charAt(i+1));
        }

        for (int len = 3; len <=n ; len++) {
            for (int i = 0; i <=n-len ; i++) {
                int j =i+len-1;
                dp[i][j]=(str.charAt(i)==str.charAt(j))&&dp[i+1][j-1];
            }
        }
        return dp;
    }

    public static void answerQueries(String str, int[][] queries) {
        boolean[][] dp = preprocess(str);
        for (int [] query:queries) {
            int l =query[0];
            int r = query[1];
            if(dp[l][r]){
                System.out.print(1+" ");
            }
            else {
                System.out.print(0+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str1 = "abaaabaaaba";
        int[][] queries1 = {{0, 10}, {5, 8}, {2, 5}, {5, 9}};
        answerQueries(str1, queries1);
        System.out.println();

        String str2 = "abdcaaa";
        int[][] queries2 = {{0, 1}, {2, 2}, {4, 6}};
        answerQueries(str2, queries2);
    }
}

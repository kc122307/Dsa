package com.kunal.Dsa.TwoDArray;

public class MaxArea {
    static int maxArea(int[][] mat) {
        int m=mat.length,n = mat[0].length;
        int [][] memo = new int[m][n];
        int ans =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==0) continue;
                if(j==0) {
                    memo[i][j]=1;
                }
                else{
                    memo[i][j]=memo[i][j-1]+1;
                }
                int width = memo[i][j];
                for (int k = i; k >=0 ; k--) {
                    width=Math.min(width,memo[k][j]);
                    int area = width*(i-k+1);
                    ans=Math.max(ans,area);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        System.out.println(maxArea(mat));
    }
}

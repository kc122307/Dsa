package com.kunal.Dsa.Strings;

import java.util.Arrays;

public class WordWrapRecursive {
    static int [] dp;
    static int solve(int[] words, int n, int k, int index) {
        if(index==n) return 0;
        if(dp[index]!=-1){
            return dp[index];
        }
        int extraspaces = k;
        int mincost = Integer.MAX_VALUE;
        for (int j = index; j <n ; j++) {
           extraspaces-=words[j];
           if(extraspaces<0) break;
           int cost = (j==n-1)?0:(extraspaces*extraspaces);
           int totalcost = cost+solve(words,n,k,j+1);
           mincost=Math.min(mincost,totalcost);
           extraspaces-=1;
        }
        return dp[index]=mincost;
    }
    public static int wordWrap(int[] words, int n, int k) {
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(words,n,k,0);
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 5};
        int k = 6;
        System.out.println("Minimum total cost: " + wordWrap(arr, arr.length, k));
    }
}

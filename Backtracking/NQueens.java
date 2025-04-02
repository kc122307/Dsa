package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int []queens = new int[n];
        backtrack(result,queens,0,n);
        return result;
    }
    private static void backtrack(List<List<Integer>> result, int[] queens, int col, int n) {
       if(col==n){
           List<Integer> solution = new ArrayList<>();
           for (int q:queens) {
               solution.add(q+1);
           }
           result.add(solution);
       }
        for (int row = 0; row < n; row++) {
            if(isSafe(queens,col,row)){
                queens[col] = row;
                backtrack(result,queens,col+1,n);
            }
        }
    }

    private static boolean isSafe(int[] queens, int col, int row) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = queens[prevCol];
            if(prevRow==row||Math.abs(prevRow-row)==Math.abs(prevCol-col)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> solutions = solveNQueens(n);
        for (List<Integer> solution : solutions) {
            System.out.println(solution);
        }
    }
}

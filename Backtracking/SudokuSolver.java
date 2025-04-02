package com.kunal.Dsa.Backtracking;

public class SudokuSolver {
    public static boolean isValid(int[][] board, int row, int col, int num, int size) {
        for (int i = 0; i < size; i++) {
            if(board[row][i]==num||board[i][col]==num){
                return false;
            }
        }

        int boxsize =(int) Math.sqrt(size);
        int startRow =(row/boxsize)*boxsize,startCol=(col/boxsize)*boxsize;
        for (int i = 0; i <boxsize ; i++) {
            for (int j = 0; j < boxsize; j++) {
                if(board[startRow+i][startCol+j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(board[row][col]==0){
                    for (int num = 1; num <=size ; num++) {
                        if(isValid(board,row,col,num,size)){
                            board[row][col]=num;
                            if(solveSudoku(board,size)) return true;
                            board[row][col]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board, int size) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 9;
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board, size)) {
            printBoard(board, size);
        } else {
            System.out.println("No solution exists");
        }
    }
}


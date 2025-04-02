package com.kunal.Dsa.Backtracking;

public class KnightsTour {
    static int N=8;
    static int[] rowMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] colMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

    private static boolean solve(int[][] board, int x, int y, int moveCount) {
       if(moveCount==N*N) return true;
        for (int i = 0; i < 8; i++) {
            int xNew = x+rowMoves[i];
            int yNew = y+colMoves[i];
            if(isSafe(board,xNew,yNew)){
                board[xNew][yNew]=moveCount;
                if(solve(board,xNew,yNew,moveCount+1)) return true;
                board[xNew][yNew]=-1;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int x, int y) {
        return x>=0&&y>=0&&x< board.length&&y<board[0].length &&board[x][y]==-1;
    }

    private static void printBoard(int[][] board) {
        for (int [] rows:board) {
            for (int cols:rows) {
                System.out.printf("%2d ",cols);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        // Initialize the board with -1 (unvisited)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = -1;

        // Start from top-left corner
        board[0][0] = 0;

        if (solve(board, 0, 0, 1)) {
            printBoard(board);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}

package com.kunal.Dsa.TwoDArray;

public class SurroundedRegions {
    public void replaceSurrounded(char[][] board){
      if(board==null||board.length==0){
          return ;
      }
      int rows = board.length,cols=board[0].length;
        for (int i = 0; i < rows; i++) {
            if(board[i][0]=='o') dfs(board,i,0);
            if(board[i][cols-1]=='o') dfs(board,i,cols-1);
        }
        for (int i = 0; i < cols; i++) {
            if(board[0][i]=='o') dfs(board,0,i);
            if(board[rows-1][i]=='o') dfs(board,rows-1,i);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]=='o'){
                    board[i][j]='x';
                } else if (board[i][j]=='#') {
                    board[i][j]='o';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c) {
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!='o'){
            return;
        }
       board[r][c]='#';
        dfs(board, r + 1, c); // Down
        dfs(board, r - 1, c); // Up
        dfs(board, r, c + 1); // Right
        dfs(board, r, c - 1); // Left
    }
    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();

        char[][] board1 = {
                {'x', 'o', 'x', 'x', 'x', 'x'},
                {'x', 'o', 'x', 'x', 'o', 'x'},
                {'x', 'x', 'x', 'o', 'o', 'x'},
                {'o', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'o', 'x', 'o'},
                {'o', 'o', 'x', 'o', 'o', 'o'}
        };

        solution.replaceSurrounded(board1);

        // Print updated matrix
        for (char[] row : board1) {
            System.out.println(new String(row));
        }
    }
}

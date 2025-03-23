package com.kunal.Dsa.TwoDArray;

public class Solution {
    public boolean exist(char[][] board, String word) {
       int r= board.length;
       int c= board[0].length;
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j]==word.charAt(0)&&dfs(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int r, int c, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, r + 1, c, word, index + 1) ||  // Down
                dfs(board, r - 1, c, word, index + 1) ||  // Up
                dfs(board, r, c + 1, word, index + 1) ||  // Right
                dfs(board, r, c - 1, word, index + 1);    // Left
        board[r][c]=temp;
        return found;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println(solution.exist(board1, word1)); // Output: true

        String word2 = "SEE";
        System.out.println(solution.exist(board1, word2)); // Output: true

        String word3 = "ABCB";
        System.out.println(solution.exist(board1, word3)); // Output: false
    }
}

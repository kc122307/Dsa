package com.kunal.Dsa.TwoDArray;

public class NumberOfIslands {
    public int numIslands(char[][] grid){
     if(grid==null||grid[0].length==0){
         return 0;
     }
     int rows = grid.length;
     int cols = grid[0].length;
     int count=0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c) {
       if(r<0||c<0||c>=grid.length||r>=grid[0].length||grid[r][c]=='0'){
           return;
       }

       grid[r][c]='0';

        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
        dfs(grid, r - 1, c - 1); // Top-left
        dfs(grid, r - 1, c + 1); // Top-right
        dfs(grid, r + 1, c - 1); // Bottom-left
        dfs(grid, r + 1, c + 1); // Bottom-right
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '1', '0'}
        };
        System.out.println(solution.numIslands(grid1)); // Output: 4

        char[][] grid2 = {
                {'1', '1'},
                {'1', '1'}
        };
        System.out.println(solution.numIslands(grid2)); // Output: 1

        char[][] grid3 = {
                {'0', '0'},
                {'0', '0'}
        };
        System.out.println(solution.numIslands(grid3)); // Output: 0
    }
}

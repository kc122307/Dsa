package com.kunal.Dsa.StacksandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class NearestOneDistance {
    static class Cell {
        int row, column, dist;

        Cell(int row, int column, int dist) {
            this.row = row;
            this.column = column;
            this.dist = dist;
        }
    }

    public static int[][] nearestOne(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int [][] dist = new int[m][n];
        boolean [][] visited = new boolean[m][n];

        Queue<Cell> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    queue.add(new Cell(i,j,0));
                    visited[i][j]=true;
                }
            }
        }

        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};

        while (!queue.isEmpty()){
            Cell current = queue.poll();
            dist[current.row][current.column]=current.dist;
            for (int i = 0; i <4 ; i++) {
                int newRow = current.row+dx[i];
                int newCol = current.column+dy[i];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol]){
                    visited[newRow][newCol]=true;
                    queue.add(new Cell(newRow,newCol,current.dist+1));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        int[][] result = nearestOne(grid);
        for (int[] row : result) {
            for (int d : row) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}

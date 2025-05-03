package com.kunal.Dsa.StacksandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Cell {
        int row, col, time;
        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
       int m = grid.length,n=grid[0].length;
       boolean [][] visited = new boolean[m][n];
       Queue<Cell> queue = new LinkedList<>();
       int freshcount =0;
       int maxTime=0;

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]==2){
                    queue.add(new Cell(i,j,0));
                    visited[i][j]=true;
                }
                else if(grid[i][j]==1){
                    freshcount++;
                }
            }
        }

        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        int rottencount =0;

        while(!queue.isEmpty()){
            Cell current = queue.poll();
            maxTime =Math.max(maxTime,current.time);
            for (int k = 0; k < 4; k++) {
                int newRow = current.row+dx[k];
                int newCol = current.col+dy[k];
                if(newRow>=0&&newRow<m&&newCol>=0&&newCol<n&&!visited[newRow][newCol]&&grid[newRow][newCol]==1){
                    queue.add(new Cell(newRow,newCol, current.time+1));
                    visited[newRow][newCol]=true;
                    rottencount++;
                }
            }
        }
        return rottencount==freshcount?maxTime:-1;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int minutes = orangesRotting(grid);
        System.out.println("Minimum minutes to rot all oranges: " + minutes);
    }
}

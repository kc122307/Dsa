package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInMaze {
    static List<String> result = new ArrayList<>();
    public static List<String> findPath(int[][] maze, int n) {
        result.clear();

        if(maze[0][0]==0||maze[n-1][n-1]==0){
            return result;
        }

        boolean[][] visited = new boolean[n][n];
        backtrack(maze,n,0,0,"",visited);

        Collections.sort(result);
        return result;
    }

    private static void backtrack(int[][] maze, int n, int row, int col, String path, boolean[][] visited) {
     if(row==n-1&&col==n-1){
         result.add(path);
         return;
     }

     visited[row][col]=true;

     int [] dr = {1,0,0,-1};
     int [] dc = {0,-1,1,0};
     char [] dir = {'D','L','R','U'};

     for (int i = 0; i < 4; i++) {
         int newRow = row+dr[i];
         int newCol = col+dc[i];
         if(isSafe(maze,n,newRow,newCol,visited)){
             backtrack(maze,n,newRow,newCol,path+dir[i],visited);
         }
     }
     visited[row][col]=false;
    }

    static boolean isSafe(int [][] maze,int n,int row,int col,boolean[][] visited){
        return row>=0&& col>=0&& col<n&&row<n && maze[row][col]==1 &&!visited[row][col];
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int n = maze.length;

        List<String> paths = findPath(maze, n);

        if (paths.isEmpty()) {
            System.out.println("-1");  // No path found
        } else {
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }
}

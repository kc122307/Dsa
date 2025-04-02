package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ShortestSafeRoute2 {
    static int N;
    static List<List<int[]>> allPaths = new ArrayList<>();

    static int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void findPaths(int[][] maze, int x, int y, boolean[][] visited, List<int[]> path) {
        // If we reach the middle cell
        if (x == N / 2 && y == N / 2) {
            allPaths.add(new ArrayList<>(path));
            return;
        }

        visited[x][y] = true;
        int steps = maze[x][y];

        for (int[] dir : directions) {
            int newX = x + dir[0] * steps;
            int newY = y + dir[1] * steps;

            if (isValid(newX, newY) && !visited[newX][newY]) { // Fixed condition
                path.add(new int[]{newX, newY});
                findPaths(maze, newX, newY, visited, path);
                path.remove(path.size() - 1);
            }
        }

        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {3, 5, 4, 4, 7, 3, 4, 6, 3},
                {6, 7, 5, 6, 6, 2, 6, 6, 2},
                {3, 3, 4, 3, 2, 5, 4, 7, 2},
                {6, 5, 5, 1, 2, 3, 6, 5, 6},
                {3, 3, 4, 3, 0, 1, 4, 3, 4},
                {3, 5, 4, 3, 2, 2, 3, 3, 5},
                {3, 5, 4, 3, 2, 6, 4, 4, 3},
                {3, 5, 1, 3, 7, 5, 3, 6, 4},
                {6, 2, 4, 3, 4, 5, 4, 5, 1}
        };

        N = maze.length;
        boolean[][] visited = new boolean[N][N];
        int[][] corners = {{0, 0}, {0, N - 1}, {N - 1, 0}, {N - 1, N - 1}};

        for (int[] start : corners) {
            List<int[]> path = new ArrayList<>();
            path.add(new int[]{start[0], start[1]});
            findPaths(maze, start[0], start[1], visited, path);
        }

        // Print all valid paths
        System.out.println("Total Paths: " + allPaths.size());
        for (List<int[]> path : allPaths) {
            for (int i = 0; i < path.size(); i++) {
                int[] step = path.get(i);
                System.out.print("(" + step[0] + "," + step[1] + ")");
                if (i < path.size() - 1) System.out.print(" -> ");
            }
            System.out.println(" -> MID");
        }
    }
}

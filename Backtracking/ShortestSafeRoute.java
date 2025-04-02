package com.kunal.Dsa.Backtracking;

public class ShortestSafeRoute {
    static final int ROWS = 12, COLS = 10;
    static int minDist = Integer.MAX_VALUE;

    // Directions: Down, Right, Up, Left
    static int[] rowDir = {1, 0, -1, 0};
    static int[] colDir = {0, 1, 0, -1};

    // Check if a cell is safe to visit
    static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
        return (x >= 0 && y >= 0 && x < ROWS && y < COLS && mat[x][y] == 1 && !visited[x][y]);
    }

    // Backtracking function to find the shortest path
    // Backtracking function to find the shortest path
    static void findShortestPath(int[][] mat, boolean[][] visited, int x, int y, int dist) {
        System.out.println("Visiting: (" + x + ", " + y + "), Distance: " + dist);

        // Base case: If we reached the last column
        if (y == COLS - 1) {
            minDist = Math.min(minDist, dist);
            System.out.println("Reached the last column with distance: " + minDist);
            return;
        }

        // Mark current cell as visited
        visited[x][y] = true;

        // Move in all 4 possible directions
        for (int d = 0; d < 4; d++) {
            int newX = x + rowDir[d];
            int newY = y + colDir[d];

            if (isSafe(mat, visited, newX, newY)) {
                findShortestPath(mat, visited, newX, newY, dist + 1);
            }
        }

        // **Backtrack**: Unmark the cell after exploring
        visited[x][y] = false;
        System.out.println("Backtracking from: (" + x + ", " + y + ")");
    }



    // Function to find the shortest path from the first column
    static int findShortestPath(int[][] mat) {
        boolean[][] visited = new boolean[ROWS][COLS];
        minDist = Integer.MAX_VALUE;

        // Try from each row in the first column
        for (int i = 0; i < ROWS; i++) {
            if (mat[i][0] == 1) { // If the first column's cell is traversable
                findShortestPath(mat, visited, i, 0, 0);
            }
        }

        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int shortestPath = findShortestPath(mat);
        if (shortestPath != -1) {
            System.out.println("Shortest Safe Route Distance: " + shortestPath);
        } else {
            System.out.println("No safe path found.");
        }
    }
}

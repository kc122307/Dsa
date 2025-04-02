package com.kunal.Dsa.Backtracking;

import java.util.Arrays;

public class MColoringProblem {
    public static boolean graphColoring(int[][] graph, int m, int v) {
       int [] color = new int[v];
       Arrays.fill(color,0);
       return solve(0,graph,color,m,v);
    }
    private static boolean solve(int node, int[][] graph, int[] color, int m, int v) {
        if(node==v) return true;
        for (int c = 1; c <=m ; c++) {
            if(isSafe(node,graph,color,c,v)) {
                color[node] = c;
                if (solve(node + 1, graph, color, m, v)) return true;
                color[node] = 0;
            }
        }
        return false;
    }
    private static boolean isSafe(int node, int[][] graph, int[] color, int c, int v) {
        for (int i = 0; i < v; i++) {
            if(graph[node][i]==1&&color[i]==c){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int v = 4, m = 3;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2} };

        // Convert edge list to adjacency matrix
        int[][] graph = new int[v][v];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        System.out.println(graphColoring(graph, m, v)); // Output: true
    }
}

package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class GraphIsTree {
    public static boolean isTree(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];

        if(hasCycle(0,-1,visited,adj)){
            return false;
        }
        for (boolean v:visited) {
            if(!v){
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
       visited[node]=true;

        for (int neighbour:adj.get(node)) {
            if(!visited[neighbour]){
                if(hasCycle(neighbour,node,visited,adj)) return true;
            }
            else if (neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Example tree
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(1).add(4); adj.get(4).add(1);

        System.out.println(isTree(n, adj)); // Output: true
    }
}

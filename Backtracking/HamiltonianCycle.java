package com.kunal.Dsa.Backtracking;

public class HamiltonianCycle {
    public static boolean isSafe(int[][] graph, int[] path, int pos, int v) {
       if(graph[path[pos-1]][v]==0){
           return false;
       }
        for (int i = 0; i < pos; i++) {
            if(path[i]==v){
                return false;
            }
        }
        return true;
    }

    public static boolean hamiltonianCycleUtil(int[][] graph, int[] path, int pos) {
       if(pos== graph.length){
           if(graph[path[pos-1]][0]==1){
               return true;
           }
           else{
               return false;
           }
       }
        for (int v = 1; v< graph.length; v++) {
            if(isSafe(graph,path,pos,v)){
                path[pos]=v;
                if(hamiltonianCycleUtil(graph,path,pos+1)){
                    return true;
                }
                path[pos]=-1;
            }
        }
        return false;
    }


    public static boolean hamiltonianCycle(int[][] graph) {
       int [] path = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            path[i]=-1;
        }
        path[0]=0;
        if(!hamiltonianCycleUtil(graph,path,1)){
            return false;
        }
        System.out.println("Hamiltonian cycle: ");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(path[i] + " ");
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        if (!hamiltonianCycle(graph)) {
            System.out.println("No Hamiltonian Cycle");
        }
    }
}

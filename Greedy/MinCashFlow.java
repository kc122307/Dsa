package com.kunal.Dsa.Greedy;

public class MinCashFlow {
    static final int N = 3;

    static int getMax(int[] net) {
       int maxIndex =0;
        for (int i = 1; i <N ; i++) {
            if(net[maxIndex]<net[i]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    static int getMin(int [] net){
       int minIndex =0;
        for (int i = 1; i <N ; i++) {
            if(net[minIndex]>net[i]){
                minIndex=i;
            }
        }
        return minIndex;
    }
    static void minCashFlowRec(int[] net) {
        int maxCredit =getMax(net);
        int maxDebit =getMin(net);

        if(net[maxCredit]==0||net[maxDebit]==0){
            return;
        }
        int min =Math.min(net[maxCredit],-net[maxDebit]);
        net[maxCredit]-=min;
        net[maxDebit]+=min;

        System.out.println("Person " + maxDebit + " pays " + min + " to Person " + maxCredit);
        minCashFlowRec(net);
    }

    static void minCashFlow(int[][] graph) {
       int [] net = new int[N];
        for (int p = 0; p < N; p++) {
            for (int i = 0; i < N; i++) {
                net[p]+=(graph[i][p]-graph[p][i]);
            }
        }
        minCashFlowRec(net);
    }
    public static void main(String[] args) {
        int[][] transaction = {
                {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}
        };

        minCashFlow(transaction);
    }
}

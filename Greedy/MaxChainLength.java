package com.kunal.Dsa.Greedy;


import java.util.Arrays;

class Pair {
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class MaxChainLength {
    public static int maxChainLength(int[][] input) {
        int n = input.length;

        Pair[] pairs = new Pair[n];
        for (int i = 0; i <n ; i++) {
            pairs[i] = new Pair(input[i][0],input[i][1]);
        }

        Arrays.sort(pairs,(a,b) -> a.second - b.second);

        int chainlength=1;
        int lastindex=0;

        for (int i = 1; i <n ; i++) {
            if(pairs[i].first>pairs[lastindex].second){
                chainlength++;
                lastindex=i;
            }
        }
        return chainlength;
    }
    public static void main(String[] args) {
        int[][] input = {
                {5, 24},
                {39, 60},
                {15, 28},
                {27, 40},
                {50, 90}
        };

        System.out.println("Length of maximum chain is " + maxChainLength(input));
    }
}

package com.kunal.Dsa.Greedy;

import java.util.Arrays;
import java.util.Collections;

public class BoardCutting {
    public static int minCost(int m, int n, Integer[] x, Integer[] y) {
       Arrays.sort(x,Collections.reverseOrder());
       Arrays.sort(y,Collections.reverseOrder());

       int horizontalPieces=1,verticalPieces=1;
       int hCuts=0,vCuts=0;
       int cost=0;
       while(hCuts<x.length&&vCuts<y.length){
           if(x[hCuts]>y[vCuts]){
               cost+=x[hCuts]*verticalPieces;
               horizontalPieces++;
               hCuts++;
           }
           else{
               cost+=y[vCuts]*horizontalPieces;
               verticalPieces++;
               vCuts++;
           }
       }

       while(hCuts<x.length){
           cost+=x[hCuts]*verticalPieces;
           hCuts++;
       }
       while (vCuts<y.length){
           cost+=y[vCuts]*horizontalPieces;
           vCuts++;
       }
       return cost;
    }
    public static void main(String[] args) {
        Integer[] x = {2, 1, 3, 1, 4};
        Integer[] y = {4, 1, 2};
        int m = 6, n = 4;

        System.out.println(minCost(m, n, x, y)); // Output: 42
    }
}

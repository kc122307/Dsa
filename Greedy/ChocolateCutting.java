package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class ChocolateCutting {
    private static int minCost(int[] x, int[] y) {
       Arrays.sort(x);
       Arrays.sort(y);

       int m = x.length;
       int n =y.length;

       int i=m-1;
       int j=n-1;

       int totalcost=0;
       int horizontalPieces =1;
       int verticalPieces =1;

       while(i>=0&&j>=0){
           if(x[i]>y[j]){
               totalcost+=x[i]*horizontalPieces;
               verticalPieces++;
               i--;
           }
           else{
               totalcost+=y[j]*verticalPieces;
               horizontalPieces++;
               j--;
           }
       }
       while (i>=0){
           totalcost+=x[i]*horizontalPieces;
           i--;
       }
       while(j>=0) {
           totalcost+=y[j]*verticalPieces;
           j--;
       }
       return totalcost;
    }
    public static void main(String[] args) {
        int[] x = {2, 1, 3, 1, 4}; // Vertical cut costs
        int[] y = {4, 1, 2};        // Horizontal cut costs

        int result = ChocolateCutting.minCost(x, y);
        System.out.println("Minimum cost to cut the chocolate into pieces: " + result);
    }
}

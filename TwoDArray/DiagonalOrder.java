package com.kunal.Dsa.TwoDArray;

import java.util.ArrayList;

public class DiagonalOrder {
    public static void diagonalOrder(int[][] arr, int n, int m)
    {
       ArrayList<ArrayList<Integer>> ans= new ArrayList<>(n+m-1);
        for (int i = 0; i <n+m-1 ; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans.get(i+j).add(arr[i][j]);
            }
        }
        for (int i = 0; i <ans.size() ; i++) {
            for (int j = ans.get(i).size()-1; j >=0 ; j--) {
                System.out.print(ans.get(i).get(j)+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
            int n = 5, m = 4;
            int[][] arr={
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 },
                    { 17, 18, 19, 20 },
            };

            // Function call
            diagonalOrder(arr, n, m);
        }
}

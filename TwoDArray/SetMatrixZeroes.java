package com.kunal.Dsa.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix){
        int m = matrix.length,n= matrix[0].length;
        boolean firstRowZero = false,firstColZero=false;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j]==0){
                    if(i==0) firstRowZero=true;
                    if(j==0) firstColZero=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            Arrays.fill(matrix[0],0);
        }

        if(firstColZero){
            for (int i = 0; i <m ; i++) {
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}

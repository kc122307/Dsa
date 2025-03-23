package com.kunal.Dsa.TwoDArray;

import java.util.Scanner;

public class MatrixPattern {
    static void generateMatrix(int m, int n){
      char [][] mat = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int layer = Math.min(Math.min(i,m-1-i),Math.min(j,n-1-j));
                mat[i][j]=(layer%2==0)?'X':'O';
            }
        }
        printMatrix(mat,m,n);
    }
    static void printMatrix(char[][] mat, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Input for Matrix Dimensions
        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();
        sc.close();

        // Generate and print the matrix pattern
        generateMatrix(m, n);
    }
}

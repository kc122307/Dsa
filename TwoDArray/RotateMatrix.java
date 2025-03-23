package com.kunal.Dsa.TwoDArray;

import java.util.Arrays;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
      int n= matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left=0,right=n-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        // Output: [[7,4,1],[8,5,2],[9,6,3]]

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
        // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}

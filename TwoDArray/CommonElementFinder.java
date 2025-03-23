package com.kunal.Dsa.TwoDArray;

import java.util.HashMap;

public class CommonElementFinder {
    static int findCommon(int[][] mat) {
       int rows= mat.length;
       int cols = mat[0].length;
       HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(countMap.containsKey(mat[i][j])){
                    countMap.put(mat[i][j],countMap.get(mat[i][j])+1);
                }
                else{
                    countMap.put(mat[i][j],1);
                }
            }
        }
        for (int key :countMap.keySet()) {
            if(countMap.get(key)==rows){
                return key;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9}
        };

        int result = findCommon(mat);
        if (result == -1)
            System.out.println("No common element");
        else
            System.out.println("Common element is: " + result);
    }
}

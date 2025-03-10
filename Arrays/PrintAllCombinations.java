package com.kunal.Dsa;

import java.util.Arrays;

public class PrintAllCombinations {
    static void printArray(int [] data,int r){
        for (int i = 0; i < r; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    static void printCombination(int arr[],int r,int n){
        int [] data  = new int [r];
        Arrays.sort(arr);
        combinationUtil(arr,data,r,n,0,0);
    }
    static  void combinationUtil(int arr[],int [] data,int r,int n,int index,int i){
        if(index==r){
            printArray(data,r);
            return;
        }
        if(i>=n){
            return;
        }
        data[index]=arr[i];
        combinationUtil(arr, data, r, n, index+1, i+1);
        while(i<n-1&&arr[i]==arr[i+1]){
            i++;
        }
        combinationUtil(arr, data, r, n, index, i+1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 1};
        int r = 3;
        int n = arr.length;
        printCombination(arr, r, n);

    }
}


package com.kunal.Dsa.BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinSwapsToBST {
    public static void inorder(int[] arr, List<Integer> inorderList, int index) {
        if(index>= arr.length) return;
        inorder(arr,inorderList,2*index+1);
        inorderList.add(arr[index]);
        inorder(arr,inorderList,2*index+2);
    }
    public static int minSwaps(List<Integer> inorderList) {
        int n =inorderList.size();
        int [][]arrPos = new int[n][2];

        for (int i = 0; i < n; i++) {
            arrPos[i][0]=inorderList.get(i);
            arrPos[i][1]=i;
        }

        Arrays.sort(arrPos,Comparator.comparingInt(a->a[0]));

        boolean [] visited = new boolean[n];
        Arrays.fill(visited,false);

        int swaps =0;

        for (int i = 0; i < n; i++) {
            if(visited[i]||arrPos[i][1]==1) continue;
            int cycle_size =0;

            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=arrPos[j][1];
                cycle_size++;
            }

            if(cycle_size>1){
                swaps+=(cycle_size-1);
            }
        }
        return swaps;
    }
    public static int getMinSwaps(int[] arr) {
       List<Integer> inorderList = new ArrayList<>();
       inorder(arr,inorderList,0);
       return minSwaps(inorderList);
    }
    public static void main(String[] args) {
        int[] arr1 = {5, 6, 7, 8, 9, 10, 11};
        int[] arr2 = {1, 2, 3};

        System.out.println("Minimum swaps for arr1: " + getMinSwaps(arr1));
        System.out.println("Minimum swaps for arr2: " + getMinSwaps(arr2));
    }
}

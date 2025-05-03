package com.kunal.Dsa.Greedy;

public class MinCoins {
    public static int findMin(int n, int[] denomination) {
      int count=0;
        for (int i = denomination.length-1; i >=0 ; i--) {
            while(n>=denomination[i]){
                n-=denomination[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] denomination = {1, 2, 5, 10};
        int n = 39;
        System.out.println("Minimum coins: " + findMin(n, denomination)); // Output: 6
    }
}

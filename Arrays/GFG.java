package com.kunal.Dsa;

public class GFG {
    static  void reverseArray(int [] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n / 2; i++) {
            temp[i] = arr[n - i - 1];
            arr[n - i - 1] = arr[i];
            arr[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,9,8,9};
        reverseArray(arr);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

package com.kunal.Dsa;

public class MinMaxFinder {
    public static void MaxandMin(int [] arr){
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(maxi<arr[i]){
                maxi=arr[i];
            }
            if(mini>arr[i]){
                mini=arr[i];
            }
        }
        System.out.println("Maximum value is "+maxi);
        System.out.println("Minimum value is "+mini);
    }
    public static void main(String[] args) {
        int [] arr = { 4, 9, 6, 5, 2, 3 };
        MaxandMin(arr);
    }
}
//also can sort and then find last and first
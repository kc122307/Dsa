package com.kunal.Dsa.Sorting_Searching;

import java.util.Arrays;

public class RadixSort {
    private static int getMax(int[] arr) {
        int max =arr[0];
        for (int num:arr) {
            if(max<num){
                max=num;
            }
        }
        return max;
    }
    private static void countingSort(int[] arr, int exp) {
       int n= arr.length;
       int [] count = new int[10];
       int [] output = new int[n];
        for (int num:arr) {
            int digit = (num/exp)%10;
            count[digit]++;
        }
        for (int i = 1; i <10 ; i++) {
            count[i]+=count[i-1];
        }
        for (int i =n-1; i >=0 ; i--) {
            int digit = (arr[i]/exp)%10;
            output[count[digit]-1]=arr[i];
            count[digit]--;
        }
        System.arraycopy(output,0,arr,0,n);
    }
    public static void radixSort(int[] arr) {
        int max= getMax(arr);
        for (int exp = 1;max/exp>0 ;exp*=10) {
            countingSort(arr,exp);
        }
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

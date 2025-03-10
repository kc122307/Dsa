package com.kunal.Dsa;

public class NextPermutation {
    static void nextpermutation(int [] arr){
        int n= arr.length;
        int pivot =-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot==-1){
            reverse(0,arr.length-1,arr);;
            return;
        }
        for(int i=n-1;i>=pivot;i--){
            if(arr[i]>arr[pivot]){
                swap(i,pivot,arr);
                break;
            }
        }
        reverse(pivot+1,n-1,arr);
    }

    static void swap(int i ,int j,int [] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void reverse(int start,int end,int [] arr){
        while(start<end){
            swap(start++, end--, arr);
        }
    }
    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        nextpermutation(arr);

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}

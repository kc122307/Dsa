package com.kunal.Dsa.Sorting_Searching;

public class InversionCount {
    static int mergeAndCount(int[] arr, int temp[], int left, int right) {
        int mid,invCount=0;
        if(left<right){
            mid =left+(right-left)/2;
            invCount+=mergeAndCount(arr,temp,left,mid);
            invCount+=mergeAndCount(arr,temp,mid+1,right);
            invCount+=merge(arr,temp,left,mid,right);
        }
        return invCount;
    }
    static int merge(int[] arr, int temp[], int left, int mid, int right) {
       int i=left,j=mid+1,k=left,invCount=0;
       while (i<=mid&&j<=right){
           if(arr[i]<=arr[j]){
               temp[k++]=arr[i++];
           }
           else{
               temp[k++]=arr[j++];
               invCount+=(mid-i+1);
           }
       }
       while (i<=mid){
           temp[k++]=arr[i++];
       }
        while (j<=right){
            temp[k++]=arr[j++];
        }

        for (int l = left; l <=right ; l++) {
            arr[l]=temp[l];
        }
        return invCount;
    }

    static int countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeAndCount(arr,temp,0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 3, 5};
        System.out.println("Inversion count: " + countInversions(arr1));  // Output: 3

        int[] arr2 = {2, 3, 4, 5, 6};
        System.out.println("Inversion count: " + countInversions(arr2));  // Output: 0

        int[] arr3 = {10, 10, 10};
        System.out.println("Inversion count: " + countInversions(arr3));  // Output: 0
    }
}

package com.kunal.Dsa.Sorting_Searching;

public class ReverseSubarrayToSort {
    public static String canSortByReversing(int[] arr) {
        int n = arr.length;
        int L=-1,R=-1;
        for (int i = 0; i < n-1; i++) {
            if(arr[i]>arr[i+1]){
                L=i;
                break;
            }
        }

        if(L==-1)  return "Yes";

        for (int i = n-1; i>0 ; i--) {
            if(arr[i]<arr[i-1]){
                R=i;
                break;
            }
        }

        if(R==-1) R=n-1;

        if((L==0||arr[L-1]<=arr[R])&&(R==n-1||arr[L]<arr[R+1])){
            return "Yes";
        }
        else{
            return "No";
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 4, 3};
        System.out.println(canSortByReversing(arr1)); // Output: Yes

        int[] arr2 = {1, 2, 4, 5, 3};
        System.out.println(canSortByReversing(arr2)); // Output: No
    }
}

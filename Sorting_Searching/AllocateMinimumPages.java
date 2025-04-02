package com.kunal.Dsa.Sorting_Searching;

public class AllocateMinimumPages {
    static boolean isPossible(int[] arr, int n, int m, int maxPages) {
       int studentCount=1,pages=0;
        for (int i = 0; i < arr.length; i++) {
            if (pages + arr[i] > maxPages) {
                studentCount++;
                pages = arr[i];
            }
            if (studentCount > m) return false;
            else {
                pages += arr[i];
            }
        }
        return true;
    }
    static int findPages(int[] arr, int n, int m) {
        if(m>n) return -1;
        int low=Integer.MIN_VALUE,high=0;
        for (int num:arr) {
            low=Math.max(low,num);
            high+=num;
        }

        int result =high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(arr,n,m,mid)){
                result =mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int students = 2;
        int n = arr.length;

        System.out.println("Minimum pages required: " + findPages(arr, n, students));
    }
}

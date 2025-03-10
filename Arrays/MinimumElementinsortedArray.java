package com.kunal.Dsa;

public class MinimumElementinsortedArray {
    static int find(int [] arr){
        int high = arr.length-1;
        int low = 0;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[low]<=arr[high]){
                ans = Integer.min(ans,arr[low]);
                break;
            }
            if(arr[low]<=arr[mid]){
                ans = Integer.min(ans,arr[low]);
                low=mid+1;
            }
            else{
                ans = Integer.min(ans,arr[mid]);;
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println(find(arr));
    }
}

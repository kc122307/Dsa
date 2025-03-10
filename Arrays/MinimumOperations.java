package com.kunal.Dsa;

public class MinimumOperations {
    static int MinOps(int [] arr){
        int ans = 0;
        int n = arr.length;;
        int i=0;
        int j=n-1;
        while(i<j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }
            else if (arr[i]>arr[j]) {
                j--;
                arr[j]+=arr[j+1];
                ans++;
            }
            else{
                i++;
                arr[i]+=arr[i-1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 9, 1};  // Example array
        System.out.println("Minimum operations required: " +
                MinOps(arr));
    }
}

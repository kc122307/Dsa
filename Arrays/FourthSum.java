package com.kunal.Dsa.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourthSum {
    static List<List<Integer>> findfour(int [] arr,int target){
        int n= arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<n-3;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            for (int j = i+1; j <n-2; j++) {
                if(j>i+1&&arr[j]==arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum==target){
                        ans.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        l--;
                        k++;
                        while(k<l&&arr[l]==arr[l+1]) l--;
                        while(k<l&&arr[k]==arr[k-1]) k++;
                    }
                    else if (sum>target) {
                        l--;
                    }
                    else {
                        k++;

                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int target = 23;
        List<List<Integer>> ans = findfour(arr, target);
        for (List<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

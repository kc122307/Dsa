package com.kunal.Dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    static List<List<Integer>> findtriplets(int [] arr){
       List<List<Integer>> ans = new ArrayList<>();
       int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum>0){
                    k--;
                }
                else if (sum<0) {
                    j++;
                }
                else{
                    ans.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    k--;
                    j++;
                    while(j<k&&arr[j]==arr[j-1]) j++;
                    while(j<k&&arr[k]==arr[k+1]) k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        List<List<Integer>> res = findtriplets(arr);
        for (List<Integer> triplet : res) {
            System.out.println(triplet.get(0) + " " + triplet.get(1) + " " + triplet.get(2));
        }
    }
}

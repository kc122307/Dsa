package com.kunal.Dsa;

import java.util.ArrayList;

public class RepaetingandMissing {
    static ArrayList<Integer> findrepandmiss(int [] arr){
        int n = arr.length;
        int s = (n*(n+1))/2;

        int ssq = (n*(n+1)*(2*n+1))/6;

        int missing = 0;
        int repeating = 0;

        for (int i = 0; i < n; i++) {
           s -= arr[i];
           ssq -= arr[i] * arr[i];
        }
        missing = (s+ssq/s)/2;
        repeating = missing-s;

        ArrayList<Integer> array = new ArrayList<>();
        array.add(missing);
        array.add(repeating);
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        ArrayList<Integer> ans = findrepandmiss(arr);
        System.out.println(ans.get(0) + " " + ans.get(1));

    }
}

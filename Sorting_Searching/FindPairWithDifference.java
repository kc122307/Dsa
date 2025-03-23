package com.kunal.Dsa.Sorting_Searching;

import java.util.HashSet;

public class FindPairWithDifference {
    public static void findPair(int[] arr, int n) {
       HashSet<Integer> set = new HashSet<>();
        for (int num:arr) {
            set.add(num);
        }
        for (int num:arr) {
            if(set.contains(num+n)){
                System.out.println("Pair found: ("+(num+n) + ',' + num +")");
                return;
            }
            if(set.contains(num-n)){
                System.out.println("Pair found: ("+(num-n) + ',' + num +")");
                return;
            }
        }
        System.out.println("No Pair found");
    }
    public static void main(String[] args) {
        int[] arr1 = {5, 20, 3, 2, 50, 80};
        int n1 = 78;
        findPair(arr1, n1);  // Output: Pair Found: (2, 80)

        int[] arr2 = {90, 70, 20, 80, 50};
        int n2 = 45;
        findPair(arr2, n2);  // Output: No Such Pair
    }
}

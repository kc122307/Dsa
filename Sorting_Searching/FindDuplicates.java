package com.kunal.Dsa.Sorting_Searching;

import java.util.HashSet;

public class FindDuplicates {
    public static void findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        for (int num:arr) {
            if(seen.contains(num)){
                duplicates.add(num);
            }
            else{
                seen.add(num);
            }
        }
        System.out.println(duplicates);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 3, 6, 1};
        findDuplicates(arr1); // Output: [1, 3, 6]

        int[] arr2 = {1, 2, 3, 4, 3};
        findDuplicates(arr2); // Output: [3]
    }
}

package com.kunal.Dsa.Sorting_Searching;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPermutationCheck {
    public static String isPossible(Integer[] a, int[] b, int k) {
       Arrays.sort(b);
       Arrays.sort(a,Collections.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            if(a[i]+b[i]<k){
                return "No";
            }
        }
       return "Yes";
    }
    public static void main(String[] args) {
        Integer[] a1 = {2, 1, 3};
        int[] b1 = {7, 8, 9};
        int k1 = 10;
        System.out.println(isPossible(a1, b1, k1));  // Output: Yes

        Integer[] a2 = {1, 2, 2, 1};
        int[] b2 = {3, 3, 3, 4};
        int k2 = 5;
        System.out.println(isPossible(a2, b2, k2));
    }
}

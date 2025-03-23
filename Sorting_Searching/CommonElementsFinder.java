package com.kunal.Dsa.Sorting_Searching;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsFinder {
    static List<Integer> commonElements(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> common = new ArrayList<>();
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                if (common.isEmpty() || common.get(common.size() - 1) != arr1[i]) {
                    common.add(arr1[i]);
                }
                i++;
                j++;
                k++;
            }
            else if (arr1[i]<arr2[j]) {
                i++;
            }
            else if (arr2[j]<arr3[k]) {
                j++;
            }
            else {
                k++;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 30};
        int[] arr2 = {5, 13, 15, 20};
        int[] arr3 = {5, 20};

        List<Integer> common = commonElements(arr1, arr2, arr3);

        // Print output
        if (common.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(common);
        }
    }
}

package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistinctElementsInWindow {
    public static List<Integer> countDistinct(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i <k ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1 );
        }
        result.add(map.size());

        for (int i = k; i < arr.length ; i++) {
            int outElement = arr[i-k];
            map.put(outElement,map.get(outElement)-1);
            if(map.get(outElement)==0){
                map.remove(outElement);
            }

            int inElement = arr[i];
            map.put(inElement,map.getOrDefault(inElement,0)+1);

            result.add(map.size());
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 3, 4, 2, 3};
        int k1 = 4;
        System.out.println(countDistinct(arr1, k1)); // Output: [3, 4, 4, 3]

        int[] arr2 = {4, 1, 1};
        int k2 = 2;
        System.out.println(countDistinct(arr2, k2)); // Output: [2, 1]
    }
}

package com.kunal.Dsa;


import java.util.Arrays;

public class ContainsDuplicate {
    static boolean Duplicate(int [] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr =  {1,2,3,1};
        if (Duplicate(arr)) {
            System.out.println("Array has duplicate");
        } else {
            System.out.println("All elements are distinct.");
        }
    }
}

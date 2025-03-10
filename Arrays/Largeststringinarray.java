package com.kunal.Dsa;

import java.util.Arrays;

public class Largeststringinarray {
    static String largestnum(int [] arr){
       String [] strnums = new String[arr.length];
       for(int i=0;i< arr.length;i++){
           strnums[i]= String.valueOf(arr[i]);
       }
       Arrays.sort(strnums,(a,b)->(b+a).compareTo(a+b));
       if(strnums[0].equals("0")){
           return "0";
       }
       StringBuilder result = new StringBuilder();
       for(String num:strnums){
           result.append(num);
       }
       return result.toString();
    }
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest Number: " + largestnum(nums));
    }
}

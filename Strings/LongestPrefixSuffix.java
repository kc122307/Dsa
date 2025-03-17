package com.kunal.Dsa.Strings;

public class LongestPrefixSuffix {
    public static int longestPrefixSuffix(String s) {
       int n= s.length();
       if(n==0){
           return 0;
       }
       int len =0,i=1;
       int lps [] = new int[n];
       while(i<n){
           if(s.charAt(i)==s.charAt(len)){
               len++;
               lps[i]=len;
               i++;
           }
           else{
               if(len!=0){
                   len =lps[len-1];
               }
               else{
                   lps[i]=0;
                   i++;
               }
           }
       }
       return lps[n-1];
    }
    public static void main(String[] args) {
        System.out.println(longestPrefixSuffix("abab"));         // Output: 2
        System.out.println(longestPrefixSuffix("aabcdaabc"));    // Output: 4
        System.out.println(longestPrefixSuffix("aaaa"));         // Output: 3
    }
}

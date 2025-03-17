package com.kunal.Dsa.Strings;

import java.util.Arrays;

public class BoyerMoore {
    private static void badCharHeuristic(String pattern, int[] badChar) {
      Arrays.fill(badChar,-1);
        for (int i = 0; i < pattern.length(); i++) {
            badChar[pattern.charAt(i)] = i;
        }
    }
    public static void search(String text, String pattern) {
      int m= pattern.length();
      int n= text.length();
      int [] badchar = new int[256];
      badCharHeuristic(pattern,badchar);
      int s=0;
      while(s<=(n-m)){
          int j =m-1;
          while(j>=0&&text.charAt(s+j)==pattern.charAt(j)){
              j--;
          }
          if(j<0){
              System.out.println("Pattern found at "+ s);
              s+=(s+m<n)?m-badchar[text.charAt(s+m)]:1;
          }
          else{
             s+= Math.max(1,j-badchar[text.charAt(s+j)]);
          }
      }
    }
    public static void main(String[] args) {
        String text = "ABAAABCDABC";
        String pattern = "ABC";

        search(text, pattern);
    }
}

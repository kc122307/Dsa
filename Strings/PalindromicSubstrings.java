package com.kunal.Dsa.Strings;

public class PalindromicSubstrings {
    public static int countSubstrings(String s){
        int count =0;
        int n =s.length();
        for (int i = 0; i < n; i++) {
            count+=expandFromCenter(s,i,i);
            count+=expandFromCenter(s,i,i+1);
        }
        return count;
    }
    private static int expandFromCenter(String s, int left, int right){
        int count=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));  // Output: 6
        System.out.println(countSubstrings("abc"));  // Output: 3
        System.out.println(countSubstrings("racecar"));  // Output: 10
    }
}

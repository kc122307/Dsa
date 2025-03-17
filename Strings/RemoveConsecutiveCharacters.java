package com.kunal.Dsa.Strings;

public class RemoveConsecutiveCharacters {
    static String removeConsecutive(String s){
      if(s.length()<=1){
          return s;
      }
      StringBuilder output = new StringBuilder();
      output.append(s.charAt(0));
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i)!=s.charAt(i-1)){
                output.append(s.charAt(i));
            }
        }
        return output.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeConsecutive("aabb"));   // ✅ "ab"
        System.out.println(removeConsecutive("aabaa"));  // ✅ "aba"
        System.out.println(removeConsecutive("aaabbbccc")); // ✅ "abc"
        System.out.println(removeConsecutive("abc"));    // ✅ "abc" (No duplicates)
        System.out.println(removeConsecutive("aaaaa"));  // ✅ "a"
    }
}

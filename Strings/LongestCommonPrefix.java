package com.kunal.Dsa.Strings;

public class LongestCommonPrefix {
    static String longestCommonPrefix(String [] strs){
      if(strs.length==0||strs==null){
          return " ";
      }
        for (int i = 0; i < strs[0].length(); i++) {
            char c= strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i>=strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    public static void main(String[] args) {
        String[] words1 = {"flower", "flow", "flight"};
        String[] words2 = {"dog", "racecar", "car"};
        String[] words3 = {"apple", "app", "apricot"};

        System.out.println(longestCommonPrefix(words1)); // ✅ "fl"
        System.out.println(longestCommonPrefix(words2)); // ✅ "" (No common prefix)
        System.out.println(longestCommonPrefix(words3)); // ✅ "ap"
    }
}

package com.kunal.Dsa.Strings;

import java.util.HashMap;

public class SmallestWindowSubstring{
        public static String smallestWindow(String s1, String s2) {
            if(s1.length()<s2.length()) return " ";
            HashMap<Character,Integer> s2count = new HashMap<>();
            for (char ch :s2.toCharArray()) {
                s2count.put(ch,s2count.getOrDefault(ch,0)+1);
            }
            int required = s2count.size();
            int left=0,right=0,formed=0;
            int minlen = Integer.MAX_VALUE, minstart=0;
            HashMap<Character,Integer> windowcount = new HashMap<>();
            while(right<s1.length()){
                char c = s1.charAt(right);
                windowcount.put(c,windowcount.getOrDefault(c,0)+1);
                if(s2count.containsKey(c)&&s2count.get(c).intValue()==windowcount.get(c).intValue()){
                    formed++;
                }
                while(left<=right&&required==formed){
                    int windowsize = right-left+1;
                    if(windowsize<minlen){
                        minlen= windowsize;
                        minstart=left;
                    }
                    char leftchar = s1.charAt(left);
                    windowcount.put(leftchar,windowcount.get(leftchar)-1);
                    if(s2count.containsKey(leftchar)&&windowcount.get(leftchar)<s2count.get(leftchar)){
                        formed--;
                    }
                    left++;
                }
                right++;
            }
            return minlen==Integer.MAX_VALUE ?" " :s1.substring(minstart,minstart+minlen);
        }

    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc"));  // Output: "toprac"
        System.out.println(smallestWindow("zoomlazapzo", "oza"));     // Output: "apzo"
        System.out.println(smallestWindow("zoom", "zooe"));           // Output: ""
    }
}

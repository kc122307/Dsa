package com.kunal.Dsa.Strings;

import java.util.HashMap;
import java.util.Map;

public class longestUniqueSubstr {
//    static final int MAX_CHAR = 26;
//    static int find(String str){
//       int n = str.length();
//       int [] lastindex = new int[MAX_CHAR];
//       for(int i=0;i<MAX_CHAR;i++){
//           lastindex[i] =-1;
//       }
//       int res=0;
//       int start=0;
//        for (int end = 0; end < n; end++) {
//            start = Math.max(start,lastindex[str.charAt(end)-'a']+1);
//            res= Math.max(res,end-start+1);
//            lastindex[str.charAt(end)-'a']= end;
//        }
//        return res;
//    }

    static int find(String str){
      Map<Character,Integer> lastindex = new HashMap<>();
      int res=0,end=0,start=0;
        for ( end = 0; end < str.length(); end++) {
            char ch=str.charAt(end);
            if(lastindex.containsKey(ch)){
                start = Math.max(start,lastindex.get(ch)+1);
            }
            lastindex.put(ch,end);
            res=Math.max(res,end-start+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(find(s));
    }
}

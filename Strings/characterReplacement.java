package com.kunal.Dsa.Strings;

public class characterReplacement {
    static int find(String str,int k){
       int left =0,maxlength=0,maxfreq=0;
       int [] count = new int[26];
        for (int right = 0; right < str.length(); right++) {
            count[str.charAt(right)-'A']++;
            maxfreq= Math.max(maxfreq,count[str.charAt(right)-'A']);
            while((right-left+1)-maxfreq>k){
                count[str.charAt(left)-'A']--;
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
        public static void main(String[] args) {
            int ans1 = find("AABABBA", 1);
            int ans2 = find("ABAB", 2);
            int ans3 = find("AAAB", 0);
            System.out.println(ans1); // Output: 4
            System.out.println(ans2);    // Output: 4
            System.out.println(ans3);    // Output: 3
        }
    }

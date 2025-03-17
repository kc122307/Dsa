package com.kunal.Dsa.Strings;

public class ValidAnagram {
    static boolean validana(String t,String s){
        if(s.length()!=t.length()){
            return false;
        }
        int count[] = new int[26];
        for(int i=0;i< s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int n : count){
           if(n!=0){
               return false;
           }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}

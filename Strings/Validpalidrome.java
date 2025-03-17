package com.kunal.Dsa.Strings;

public class Validpalidrome {
    static boolean validpalin(String s){
       int i=0;
       int j= s.length()-1;
     while(i<j){
         while(i<j&&!Character.isLetterOrDigit(s.charAt(i))){
             i++;
         }
         while (i<j&&!Character.isLetterOrDigit(s.charAt(j))) {
             j--;
         }
         if (Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))) {
             i++;
             j--;
         } else{
             return false;
         }
     }
     return true;
    }
    public static void main(String[] args) {
        String s = "Too hot to hoot.";

        System.out.println(validpalin(s)
                ? "True" : "False");
    }
}

package com.kunal.Dsa.Strings;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    static void printdups(String str){
       Map<Character,Integer> charcount = new HashMap<>();
        for (char ch :str.toCharArray()) {
            charcount.put(ch,charcount.getOrDefault(ch,0)+1);
        }
        for (Map.Entry<Character,Integer> entry:charcount.entrySet()) {
            if(entry.getValue()>1){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        String str = "programming";
        printdups(str);
    }
}

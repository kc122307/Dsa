package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public static List<List<String>> groupShiftedStrings(String[] strings) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str:strings) {
            String key = getShiftKey(str);
            map.computeIfAbsent(key,k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static String getShiftKey(String str) {
       if(str.length()==0) return "";

       StringBuilder key = new StringBuilder();
       int shift = str.charAt(0)-'a';

        for (char ch:str.toCharArray()) {
            char normalized = (char) ((ch-shift+26-'a')%26 +'a');
            key.append(normalized);
        }
        return key.toString();
    }

    public static void main(String[] args) {
        String[] arr1 = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};
        String[] arr2 = {"geek", "for", "geeks"};

        System.out.println(groupShiftedStrings(arr1));
        System.out.println(groupShiftedStrings(arr2));
    }
}

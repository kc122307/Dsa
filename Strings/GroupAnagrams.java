package com.kunal.Dsa.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str:strs) {
            int count[] = new int[26];
            for (char ch:str.toCharArray()) {
                count[ch-'a']++;
            }
            StringBuilder keybuilder = new StringBuilder();
            for (int num:count) {
                keybuilder.append(num).append('#');
            }
            String key = keybuilder.toString();
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return  new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }
}
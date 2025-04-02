package com.kunal.Dsa.Backtracking;

import java.util.*;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String,List<String>> memo = new HashMap<>();
        return backtrack(s,dict,memo);
    }
    private static List<String> backtrack(String s, Set<String> dict, Map<String, List<String>> memo) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.isEmpty()) return Arrays.asList();

        List<String> result = new ArrayList<>();

        for (int i = 1; i <=s.length() ; i++) {
            String prefix = s.substring(0,i);
            if(dict.contains(prefix)){
                List<String> suffixWays = backtrack(s.substring(i),dict,memo);
                for (String suffix : suffixWays) {
                    result.add(prefix + (suffix.isEmpty() ? "" : " " + suffix));
                }
            }
        }
        memo.put(s, result); // Store in memo for future reference
        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        System.out.println(wordBreak(s, dict));

        String s2 = "pineapplepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        System.out.println(wordBreak(s2, dict2));
    }
}

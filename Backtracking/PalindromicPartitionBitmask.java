package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitionBitmask {
    static boolean isPalindrome(String str, int left, int right) {
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if(start==s.length()){
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        for (int end = start; end <s.length() ; end++) {
            if(isPalindrome(s,start,end)){
                currentPartition.add(s.substring(start,end+1));
                backtrack(s,end+1,currentPartition,result);
                currentPartition.remove(currentPartition.size()-1);
            }
        }
    }
    static void printPalindromicPartitions(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),result);
        for (List<String> ans:result) {
            System.out.println(String.join(" ", ans));
        }
    }

    // Driver Code
    public static void main(String[] args) {
        System.out.println("Palindromic partitions of 'nitin':");
        printPalindromicPartitions("nitin");

        System.out.println("\nPalindromic partitions of 'geeks':");
        printPalindromicPartitions("geeks");
    }
}

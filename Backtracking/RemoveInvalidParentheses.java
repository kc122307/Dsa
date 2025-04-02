package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String > result = new ArrayList<>();
        if(s==null) return result;
        int [] minremoval = getMinRemovals(s);
        backtrack(s,0,minremoval[0],minremoval[1],new StringBuilder(),0,result,new HashSet<>());
        return result;
    }

    private static void backtrack(String s, int index, int leftRem, int rightRem, StringBuilder expr, int openCount, List<String> result, Set<String> seen) {
        if(index==s.length()){
            if(leftRem==0&&rightRem==0&&openCount==0){
                String validstr = expr.toString();
                if(!seen.contains(validstr)){
                    result.add(validstr);
                    seen.add(validstr);
                }
            }
            return;
        }
        char c= s.charAt(index);
        int length = expr.length();

        if(c=='('&&leftRem>0){
            backtrack(s,index+1,leftRem-1,rightRem,expr,openCount,result,seen);
        }
        if(c==')'&&rightRem>0){
            backtrack(s,index+1,leftRem ,rightRem-1,expr,openCount,result,seen);
        }
        expr.append(c);
        if(c!='(' && c!=')'){
            backtrack(s,index+1,leftRem,rightRem,expr,openCount,result,seen);
        }
        else if(c=='('){
            backtrack(s,index+1,leftRem,rightRem,expr,openCount+1,result,seen);
        }
        else if(openCount>0){
            backtrack(s,index+1,leftRem,rightRem,expr,openCount-1,result,seen);
        }
        expr.setLength(length);
    }
    private static int[] getMinRemovals(String s) {
       int leftrem =0,rightrem=0;
        for (char c:s.toCharArray()) {
            if(c=='('){
                leftrem++;
            }
            else if(c==')'){
                if(leftrem>0) leftrem--;
                else rightrem++;
            }
        }
        return new int[]{leftrem,rightrem};
    }
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()")); // Output: ["()()()", "(())()"]
        System.out.println(removeInvalidParentheses("(v)())()")); // Output: ["(v)()()", "(v())()"]
    }
}


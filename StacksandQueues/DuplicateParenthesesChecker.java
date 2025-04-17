package com.kunal.Dsa.StacksandQueues;

import java.util.Stack;

public class DuplicateParenthesesChecker {
    public static boolean hasDuplicateParentheses(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch:expr.toCharArray()) {
            int elementsInside=0;
            if(ch==')'){
                while(!stack.isEmpty()&&stack.peek()!='('){
                    elementsInside++;
                    stack.pop();
                }
                if(!stack.isEmpty()) stack.pop();
                if(elementsInside==0) return true;
            }
            else {
                stack.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String expr1 = "((a+b)+((c+d)))";     // true
        String expr2 = "((a+b)+(c+d))";       // false
        String expr3 = "(((a+(b)))+(c+d))";   // true
        String expr4 = "(a+(b)/c)";           // false

        System.out.println(hasDuplicateParentheses(expr1)); // true
        System.out.println(hasDuplicateParentheses(expr2)); // false
        System.out.println(hasDuplicateParentheses(expr3)); // true
        System.out.println(hasDuplicateParentheses(expr4)); // false
    }
}

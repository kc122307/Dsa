package com.kunal.Dsa.StacksandQueues;

import java.util.Stack;

public class InfixToPostfixConverter {
    static int precedence(char ch) {
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c:exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Parenthesis";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (c == '^' && stack.peek() == '^') break;
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
                if(stack.peek()=='(') return "Invalid parenthesis";
                result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String expr1 = "A*(B+C)/D";
        String expr2 = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println("Infix: " + expr1);
        System.out.println("Postfix: " + infixToPostfix(expr1));
        System.out.println();

        System.out.println("Infix: " + expr2);
        System.out.println("Postfix: " + infixToPostfix(expr2));
    }
}

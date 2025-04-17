package com.kunal.Dsa.StacksandQueues;

import java.util.Stack;

public class EvaluatePostfix {

    static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String token:arr) {
            if(token.matches("-?\\d+")){
                stack.push(Integer.parseInt(token));
            }
            else{
                if(stack.size()<2){
                    throw new IllegalArgumentException("Invalid postfix Expression");
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (token){
                    case "+":
                        stack.push(val2+val1);
                        break;
                    case "-":
                        stack.push(val2-val1);
                        break;
                    case "*":
                        stack.push(val2*val1);
                        break;
                    case "/":
                        if(val1==0){
                            throw new IllegalArgumentException("Divible by zero Error");
                        }
                        stack.push(val2/val1);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + token);
                }
            }
        }
        if(stack.size()!=1){
            throw new IllegalArgumentException("Invalid postfix Expression");
        }
        return stack.pop();
    }
    public static void main(String[] args) {

        String[] arr1 = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr1)); // Output: -4

        String[] arr2 = {"100", "200", "+", "2", "/", "5", "*", "7", "+"};
        System.out.println(evaluatePostfix(arr2)); // Output: 757
    }
}

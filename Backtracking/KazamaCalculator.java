package com.kunal.Dsa.Backtracking;

import java.util.Scanner;

public class KazamaCalculator {
    private static String evaluateExpression(int[] nums, char[] ops) {
        int result = nums[0];
        StringBuilder exp = new StringBuilder();
        exp.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            exp.append(ops[i-1]).append(nums[i]);
            if(ops[i-1]=='+'){
                result+=nums[i];
            }
            else if(ops[i-1]=='-'){
                result-=nums[i];
            }
            else if(ops[i-1]=='*'){
                result*=nums[i];
            }
        }
        return (result % 101 == 0) ? exp.toString() : null;
    }

    private static String findExpression(int[] nums) {
        char [] operators ={'+','-','*'};
        int n = nums.length;
        int toatalcombinations = (int)(Math.pow(3,n-1));
        for (int i = 0; i < toatalcombinations; i++) {
            char[] ops = new char[n-1];
            int temp = i;
            for (int j = 0; j < n-1; j++) {
                ops[j] = operators[temp%3];
                temp/=3;
            }
            String expr = evaluateExpression(nums,ops);
            if(expr!=null){
                System.out.println("Valid Expression: " + expr);
                return expr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        String result = findExpression(numbers);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No valid expression found.");
        }
    }
}
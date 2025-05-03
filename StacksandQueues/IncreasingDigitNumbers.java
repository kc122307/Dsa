package com.kunal.Dsa.StacksandQueues;

public class IncreasingDigitNumbers {
    static boolean isNonDecreasing(int num) {
       int prevDigit =10;
       while(num>0){
           int currentDigit = num%10;
           if(currentDigit>prevDigit){
               return false;
           }
           prevDigit=currentDigit;
           num /=10;
       }
       return true;
    }

    public static int countNumbers(int n) {
        int count =0;
        for (int i = 1; i <=n; i++) {
            if(isNonDecreasing(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 100;

        System.out.println("Count from 1 to " + n1 + ": " + countNumbers(n1)); // Output: 14
        System.out.println("Count from 1 to " + n2 + ": " + countNumbers(n2)); // Output: 54
    }
}

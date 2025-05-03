package com.kunal.Dsa.Greedy;

public class SmallestNumberWithDigitSum {
    public static String smallestNumber(int s, int d) {
       if(s>9*d||s<0){
           return "-1";
       }

       int [] result = new int[d];
       s-=1;

        for (int i = d-1; i >0 ; i--) {
            if(s>9){
                result[i]=9;
                s-=9;
            }
            else {
                result[i]=s;
                s=0;

            }
        }

        result[0]=s+1;

        StringBuilder sb = new StringBuilder();

        for (int digit:result) {
            sb.append(digit);
        }
        return  sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber(9, 2));   // Output: 18
        System.out.println(smallestNumber(20, 3));  // Output: 299
        System.out.println(smallestNumber(1, 1));   // Output: 1
        System.out.println(smallestNumber(100, 2)); // Output: -1 (impossible)
    }
}

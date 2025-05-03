package com.kunal.Dsa.Greedy;

public class MinSquaresGreedy {
    // Function to find the minimum number of squares
    static int minSquares(int a, int b) {
        int count = 0;

        // Keep cutting the largest square possible from the rectangle
        while (a > 0 && b > 0) {
            // Always ensure a >= b by swapping if necessary
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            // Cut squares of size b x b from the rectangle
            count += a / b;  // Number of squares of size b x b that can fit in a x b

            // Update the remaining part of the rectangle
            a = a % b;  // Remainder part after cutting squares
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minSquares(5, 8));    // Output: 5
        System.out.println(minSquares(13, 11));  // Output: 6
        System.out.println(minSquares(6, 7));    // Output: 5
    }
}

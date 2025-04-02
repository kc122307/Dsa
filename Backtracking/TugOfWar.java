package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class TugOfWar {
    static int minDiff; // Minimum difference found so far
    static List<Integer> bestSubset1; // Best subset 1
    static List<Integer> bestSubset2; // Best subset 2

    // Function to calculate the sum of the elements in a list
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    // Function to recursively find the best subset
    public static void findSubset(int[] arr, int index, List<Integer> subset1, List<Integer> subset2) {
        // Base case: if we've processed all elements
        if(index== arr.length){
            if(subset1.size()==arr.length/2 &&subset2.size()== arr.length- arr.length/2){
                int sum1 = sum(subset1);
                int sum2 = sum(subset2);
                int diff = Math.abs(sum1-sum2);

                if(diff<minDiff){
                    minDiff=diff;
                    bestSubset1= new ArrayList<>(subset1);
                    bestSubset2 = new ArrayList<>(subset2);
                }
            }
            return;
        }

        subset1.add(arr[index] );
        findSubset(arr,index+1,subset1,subset2);
        subset1.remove(subset1.size()-1);

        subset2.add(arr[index]);
        findSubset(arr,index+1,subset1,subset2);
        subset2.remove(subset2.size()-1);
    }

    // Main function to solve the Tug of War problem
    public static void tugOfWar(int[] arr) {
        // Reset the global variables for each new test case
        bestSubset1= new ArrayList<>();
        bestSubset2= new ArrayList<>();
        minDiff=Integer.MAX_VALUE;

        findSubset(arr,0,new ArrayList<>(),new ArrayList<>());

        System.out.println("Subset 1:"+ bestSubset1);
        System.out.println("Subset 2:"+ bestSubset2);
        System.out.println("Mindiff: "+ minDiff);
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}; // Example 1
        System.out.println("Test Case 1:");
        tugOfWar(arr1);

        int[] arr2 = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}; // Example 2
        System.out.println("Test Case 2:");
        tugOfWar(arr2);
    }
}
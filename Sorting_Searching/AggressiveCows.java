package com.kunal.Dsa.Sorting_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    private static boolean canPlaceCows(int[] stalls, int C, int dist) {
       int cowplaced =1;
       int lastindex=stalls[0];
        for (int i = 0; i < stalls.length; i++) {
            if(stalls[i]-lastindex>=dist){
                lastindex=stalls[i];
                cowplaced++;
            }
            if(cowplaced==C){
                return true;
            }
        }
        return false;
    }

    public static int findLargestMinDistance(int[] stalls, int N, int C) {
        Arrays.sort(stalls);
        int low =1;
        int high=stalls[N-1]-stalls[0];
        int best=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPlaceCows(stalls,C,mid)){
                best=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int N = scanner.nextInt();
            int C = scanner.nextInt();
            int[] stalls = new int[N];

            for (int i = 0; i < N; i++) {
                stalls[i] = scanner.nextInt();
            }

            System.out.println(findLargestMinDistance(stalls, N, C));
        }

        scanner.close();
    }
}

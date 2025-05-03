package com.kunal.Dsa.Greedy;

public class JobAllocator {
    private static boolean isPossible(int[] job, int k, int maxTime, int unitTime) {
       int assignmentrequired =1;
       int currentTime =0;
        for (int j:job) {
            if(j*unitTime>maxTime) return false;
            if((currentTime+j)*unitTime<=maxTime){
                currentTime+=j;
            }
            else{
                assignmentrequired++;
                currentTime=j;
                if(assignmentrequired>k) return false;
            }
        }
        return true;
    }

    public static int findMinTime(int[] job, int k, int t) {
      int maxJob =0,totalJob =0;

        for (int j:job) {
            maxJob=Math.max(j,maxJob);
            totalJob+=j;
        }

        int low = maxJob*t;
        int high = totalJob*t;
        int result = high;

        while(low<=high){
            int mid =(high+low)/2;
            if(isPossible(job,k,mid,t)){
                result=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] job1 = {10, 7, 8, 12, 6, 8};
        int k1 = 4;
        int t1 = 5;
        System.out.println(findMinTime(job1, k1, t1)); // Output: 75

        int[] job2 = {4, 5, 10};
        int k2 = 2;
        int t2 = 5;
        System.out.println(findMinTime(job2, k2, t2)); // Output: 50
    }
}

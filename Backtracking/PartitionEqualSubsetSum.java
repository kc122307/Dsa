package com.kunal.Dsa.Backtracking;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] arr) {
      int totalsum=0;
        for (int num:arr) {
            totalsum+=num;
        }
      if (totalsum%2!=0) return false;
      return canPartitionHelper(arr,totalsum/2,0);
    }
    private static boolean canPartitionHelper(int[] arr, int target, int index) {
      if(target==0) return true;
      if(target<0||index>=arr.length){
          return false;
      }
      if(canPartitionHelper(arr,target-arr[index],index+1)) return true;

      return canPartitionHelper(arr,target,index+1);
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        int[] arr2 = {1, 3, 5};

        System.out.println(canPartition(arr1)); // Output: true
        System.out.println(canPartition(arr2)); // Output: false
    }
}

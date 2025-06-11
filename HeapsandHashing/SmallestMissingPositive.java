package com.kunal.Dsa.HeapsandHashing;

public class SmallestMissingPositive {
    public static int findMissingPositive(int[] nums) {
        int n =nums.length;
        for (int i = 0; i < n; i++) {
            while(nums[i]>0&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
                int temp =nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        for (int i = 0; i <n ; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
    public static void main(String[] args) {
        int[] arr1 = {2, -3, 4, 1, 1, 7};
        System.out.println(findMissingPositive(arr1)); // Output: 3

        int[] arr2 = {5, 3, 2, 5, 1};
        System.out.println(findMissingPositive(arr2)); // Output: 4

        int[] arr3 = {-8, 0, -1, -4, -3};
        System.out.println(findMissingPositive(arr3)); // Output: 1
    }
}

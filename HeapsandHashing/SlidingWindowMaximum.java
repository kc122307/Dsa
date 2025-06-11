package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0) return new int[0];
        int n =nums.length;
        int [] result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }

            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }

            deque.offer(i);

            if(i>=k-1){
                result[i-k+1]=nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1))); // [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2))); // [1]
    }
}

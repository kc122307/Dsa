package com.kunal.Dsa.Arrays;

import java.util.PriorityQueue;

public class KthSmallest {
     /*static int smallest(int [] arr,int k){
       int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int num:arr){
            minValue=Integer.min(num,minValue);
            maxValue=Integer.max(num,maxValue);
        }
        int []count = new int [maxValue-minValue+1];
        for(int num:arr){
            count[num-minValue]++;
        }
        int remain =k;
        for(int n=0;n<count.length;n++){
            remain-=count[n];
            if(remain<=0){
                return n+minValue;
            }
        }
        return -1;
    }*/

    static int maxHeap (int [] arr,int k){
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        for(int num:arr){
            maxheap.add(num);
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        return maxheap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int K = 2;
        System.out.println(maxHeap(arr, K));
    }
}

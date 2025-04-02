package com.kunal.Dsa.Sorting_Searching;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetMedian {
    static ArrayList<Double> getMedian(int[] arr) {
        PriorityQueue<Integer> leftmaxHeap = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> rightmaxHeap = new PriorityQueue<>();
        ArrayList<Double> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            leftmaxHeap.add(arr[i]);

            int temp = leftmaxHeap.poll();
            rightmaxHeap.add(temp);

            if(rightmaxHeap.size()>leftmaxHeap.size()){
                temp = rightmaxHeap.poll();
                leftmaxHeap.add(temp);
            }

            double median;
            if(rightmaxHeap.size()!=leftmaxHeap.size()){
                median= leftmaxHeap.peek();
            }
            else{
                median= (leftmaxHeap.peek()+rightmaxHeap.peek())/2.0;
            }
            res.add(median);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);
        System.out.printf("%.2f", res.get(0));

        for (int i = 1; i < res.size(); i++) {
            System.out.printf(" %.2f", res.get(i));
        }
    }
}

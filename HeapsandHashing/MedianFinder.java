package com.kunal.Dsa.HeapsandHashing;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()||num<=maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size()>maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        else{
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);                // arr = [1]
        medianFinder.addNum(2);                // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);                // arr = [1, 2, 3]
        System.out.println(medianFinder.findMedian()); // 2.0
    }
}

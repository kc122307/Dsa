package com.kunal.Dsa.HeapsandHashing;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope:ropes) {
            minHeap.offer(rope);
        }

        int totalCost =0;
        while(minHeap.size()>1){
            int first = minHeap.poll();
            int second =minHeap.poll();
            int cost = first+second;
            totalCost+=cost;
            minHeap.offer(cost);
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int[] ropes1 = {4, 3, 2, 6};
        System.out.println("Minimum cost: " + minCost(ropes1));  // Output: 29
    }
}

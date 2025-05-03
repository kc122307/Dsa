package com.kunal.Dsa.StacksandQueues;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
       int startIndex=0;
       int totalcost=0;
       int totalgas=0;
       int tank=0;
       for (int i = 0; i < gas.length; i++) {
            totalgas+=gas[i];
            totalcost+=cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                startIndex=i+1;
            }
       }
       return totalcost>totalgas?-1:startIndex;
    }
    public static void main(String[] args) {
        int[] gas1 = {4, 5, 7, 4};
        int[] cost1 = {6, 6, 3, 5};
        System.out.println("Output: " + canCompleteCircuit(gas1, cost1)); // Output: 2

        int[] gas2 = {1, 2, 3, 4, 5};
        int[] cost2 = {3, 4, 5, 1, 2};
        System.out.println("Output: " + canCompleteCircuit(gas2, cost2)); // Output: 3
    }
}

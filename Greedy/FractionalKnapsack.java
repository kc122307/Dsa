package com.kunal.Dsa.Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    static class Item{
        int weight,value;
        Item(int value,int weight){
            this.value=value;
            this.weight=weight;
        }
    }

    static double fractionalKnapsack(int capacity, int[] val, int[] wt) {
       int n =val.length;
       Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i]=new Item(val[i],wt[i]);
        }
        Arrays.sort(items,(a,b)->{
            double r1 = (double) a.value/a.weight;
            double r2 = (double) b.value/b.weight;
            return Double.compare(r2,r1);
        });

        double totalval =0;

        for (Item item: items) {
            if(capacity==0){
                return totalval;
            }
            if(item.weight<=capacity){
                totalval+=item.value;
                capacity-=item.weight;
            }
            else{
                double fraction =(double) capacity/item.weight;
                totalval+=item.value*fraction;
                capacity=0;
            }
        }
        totalval=Math.round(totalval*1e6)/1e6;
        return totalval;
    }
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        double maxValue = fractionalKnapsack(capacity, val, wt);
        System.out.println("Maximum value we can obtain = " + maxValue);

        // Another example
        int[] val2 = {500};
        int[] wt2 = {30};
        int capacity2 = 10;

        double maxValue2 = fractionalKnapsack(capacity2, val2, wt2);
        System.out.println("Maximum value we can obtain = " + maxValue2);
    }
}

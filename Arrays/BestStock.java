package com.kunal.Dsa;

public class BestStock {
    static int Maxprofit(int [] prices){
        int start = prices[0];
        int res=0;
        for (int i = 0; i < prices.length; i++) {
            start = Math.min(start,prices[i]);

            res= Math.max(res,prices[i]-start);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(Maxprofit(prices));
    }
}

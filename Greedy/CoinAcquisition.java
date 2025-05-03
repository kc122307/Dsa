package com.kunal.Dsa.Greedy;

import java.util.Arrays;
import java.util.Map;

public class CoinAcquisition {
        // Function to calculate min cost when we can get k extra coins after paying
        static int minCost(int[] coin, int n, int k) {
            // Sort the coin array to get the cheapest coins first
            Arrays.sort(coin);

            int coins_needed = (int) Math.ceil(1.0*n/(k+1));

            int totalcost=0;

            for (int i = 0; i <coins_needed ; i++) {
                totalcost+=coin[i];
            }
            return totalcost;
        }

        // Driver code
        public static void main(String[] args) {
            int[] coin = {100, 20, 50, 10, 1, 3};
            int n = coin.length;

            int k = 3;  // Can get 3 extra coins for each coin paid for
            System.out.println(minCost(coin, n, k)); // Output: 4 (minimum cost)

            k = 7;  // Can get 7 extra coins for each coin paid for
            System.out.println(minCost(coin, n, k)); // Output: 1 (minimum cost)
        }

}

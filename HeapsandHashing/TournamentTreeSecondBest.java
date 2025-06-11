package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TournamentTreeSecondBest {
    static class Node {
        int value;
        List<Integer> defeated;

        Node(int value) {
            this.value = value;
            this.defeated = new ArrayList<>();
        }
    }
    static Node buildTournament(Node[] players) {
        while(players.length>1){
            List<Node> nextRound = new ArrayList<>();

            for (int i = 0; i < players.length; i+=2) {
                if(i+1== players.length){
                    nextRound.add(players[i]);
                    continue;
                }
                Node p1 = players[i];
                Node p2 = players[i+1];

                Node winner = (p1.value>p2.value)?p1:p2;
                Node loser = (winner==p1)?p2:p1;

                winner.defeated.add(loser.value);
                winner.defeated.addAll(loser.defeated);
                nextRound.add(winner);
            }
            players=nextRound.toArray(new Node[0]);
        }
        return players[0];
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 8, 6, 2, 9, 4}; // Example

        Node[] players = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            players[i] = new Node(arr[i]);
        }

        Node winner = buildTournament(players);
        System.out.println("Best player (winner): " + winner.value);

        int secondBest = Collections.max(winner.defeated);
        System.out.println("Second best player: " + secondBest);
    }
}

package com.kunal.Dsa.Greedy;

import java.util.PriorityQueue;

public class Rearranger {
    static class Pair {
        char ch;
        int freq;
        Pair(char ch ,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public static String rearrangeString(String s) {
        int [] count = new int[26];
        for (char ch:s.toCharArray()) {
            count[ch-'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq- a.freq);
        for (char c = 'a'; c <='z' ; c++) {
            if(count[c-'a']>0){
                if(count[c-'a']>(s.length()+1)/2){
                    return "";
                }
                pq.add(new Pair(c,count[c-'a']));
            }
        }

        StringBuilder result = new StringBuilder();
        Pair prev = new Pair('#',0);
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            result.append(curr.ch);
            curr.freq--;
            if(prev.freq>0){
                pq.add(prev);
            }
            prev = curr;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(rearrangeString("aaabc"));   // e.g., abaca
        System.out.println(rearrangeString("aa"));      // ""
        System.out.println(rearrangeString("aaaabc"));  // ""
    }
}

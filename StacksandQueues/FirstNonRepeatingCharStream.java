package com.kunal.Dsa.StacksandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharStream {
    public static void firstNonRepeating(String stream) {
        int [] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i <stream.length() ; i++) {
            char ch = stream.charAt(i);
            queue.add(ch);
            freq[ch-'a']++;
            while(!queue.isEmpty()&&freq[queue.peek()-'a']>1){
                queue.poll();
            }
            if(queue.isEmpty()){
                System.out.print("-1 ");
            }
            else{
                System.out.print(queue.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String input1 = "aabc";
        String input2 = "aac";

        System.out.print("Input: " + input1 + "\nOutput: ");
        firstNonRepeating(input1);

        System.out.print("Input: " + input2 + "\nOutput: ");
        firstNonRepeating(input2);
    }
}

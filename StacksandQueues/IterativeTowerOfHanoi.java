package com.kunal.Dsa.StacksandQueues;

import java.util.Stack;

public class IterativeTowerOfHanoi {
    static class Move{
        int dest;
        String from;
        String to;

        Move(int dest,String from,String to){
            this.dest=dest;
            this.from=from;
            this.to=to;
        }
    }

    static void towerOfHanoi(int n, Stack<Integer> src, Stack<Integer> aux, Stack<Integer> dest) {
        int totalMoves = (int) Math.pow(2,n)-1;
        String s = "Source", a = "Auxiliary", d = "Destination";

        if(n%2==0){
            Stack<Integer> temp = dest;
            dest=aux;
            aux=temp;

            String tempname = d;
            d=a;
            a=tempname;
        }

        for (int i = n; i >=1 ; i--) {
            src.push(i);
        }

        for (int i = 1; i <=totalMoves ; i++) {
            if(i%3==1){
                moveDisk(src,dest,s,d);
            }
            else if(i%3==2){
                moveDisk(src,aux,s,a);
            }
            else {
                moveDisk(aux,dest,a,d);
            }
        }
    }

    static void moveDisk(Stack<Integer> from, Stack<Integer> to, String fromName, String toName) {
        int top1pole = from.isEmpty()?Integer.MAX_VALUE:from.peek();
        int top2pole = to.isEmpty()?Integer.MAX_VALUE:to.peek();
        if(top1pole<top2pole){
            to.push(from.pop());
            System.out.println("Move disk " + top1pole + " from " + fromName + " to " + toName);
        }
        else{
            from.push(to.pop());
            System.out.println("Move disk " + top2pole + " from " + toName + " to " + fromName);
        }
    }
    public static void main(String[] args) {
        int n = 3; // You can change this number for more disks
        Stack<Integer> source = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();
        Stack<Integer> destination = new Stack<>();

        towerOfHanoi(n, source, auxiliary, destination);
    }
}

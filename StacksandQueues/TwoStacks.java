package com.kunal.Dsa.StacksandQueues;

public class TwoStacks {
        int arr[];
        int size;
        int top1,top2;
        TwoStacks(int n){
            size=n;
            arr= new int[n];
            top1=-1;
            top2=n;
        }

    void push1(int x) {
       if(top1<top2-1){
           top1++;
           arr[top1]=x;
       }
       else {
           System.out.println("Stack Overflow on push1()");
       }
    }

    void push2(int x){
        if(top1<top2-1){
            top2--;
            arr[top2]=x;
        }
        else {
            System.out.println("Stack Overflow on push1()");
        }
    }

    int pop1(){
      if(top1>=0){
          int val = arr[top1];
          top1--;
          return val;
      }
      else {
          System.out.println("Stack Underflow on pop1()");
          return -1;
      }
    }

    int pop2(){
        if(top2<size){
            int val =arr[top2];
            top2++;
            return val;
        }
        else {
            System.out.println("Stack Underflow on pop2()");
            return -1;
        }
    }
        public static void main(String[] args) {
            TwoStacks ts = new TwoStacks(10);

            ts.push1(5);
            ts.push1(10);
            ts.push2(15);
            ts.push2(20);

            System.out.println(ts.pop1()); // Output: 10
            System.out.println(ts.pop2()); // Output: 20
            System.out.println(ts.pop1()); // Output: 5
            System.out.println(ts.pop2()); // Output: 15
        }
    }

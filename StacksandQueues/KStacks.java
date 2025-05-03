package com.kunal.Dsa.StacksandQueues;

public class KStacks {
    int [] arr;
    int [] top;
    int [] start;
    int [] end;
    int n,k;
    KStacks(int n,int k) {
        this.n=n;
        this.k=k;
        arr = new int[n];
        top = new int[k];
        start = new int[k];
        end = new int[k];

        int segmentationsize = n/k;
        for (int i = 0; i < k; i++) {
            start[i]= i*segmentationsize;
            end[i]=(i==k-1) ?n:(i+1)*segmentationsize;
            top[i]=start[i]-1;
        }
    }
    public void push(int x, int stackNum) throws Exception {
        if(stackNum<0&&stackNum>=k) throw  new Exception("Invalid Stack Number");

        if(top[stackNum]+1>=end[stackNum]){
            throw new Exception("Overflow Stack Error"+stackNum);
        }
        top[stackNum]++;
        arr[top[stackNum]]=x;
    }

    public int pop(int stackNum) throws Exception {
        if(stackNum<0&&stackNum>=k) throw new Exception("Invalid Stack Number");
        if(top[stackNum]<0){
            throw new Exception("Underflow Stack Error"+stackNum);
        }
        int value = arr[top[stackNum]--];
        return value;
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum]<start[stackNum];
    }
    public static void main(String[] args) throws Exception {
        KStacks ks = new KStacks(12, 3);

        ks.push(10, 0);
        ks.push(20, 0);
        ks.push(30, 1);
        ks.push(40, 2);
        ks.push(50, 2);

        System.out.println("Popped from stack 0: " + ks.pop(0));
        System.out.println("Popped from stack 1: " + ks.pop(1));
        System.out.println("Popped from stack 2: " + ks.pop(2));
    }
}

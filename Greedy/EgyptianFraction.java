package com.kunal.Dsa.Greedy;

public class EgyptianFraction {
    static void printEgyptian(int nr, int dr) {
        if(nr==0||dr==0){
            return;
        }
        if(dr%nr==0){
            System.out.print("1/"+dr/nr);
            return;
        }
        if(nr%dr==0){
            System.out.print(nr/dr);
            return;
        }
        if(nr>dr){
            System.out.print(nr/dr+" + ");
            printEgyptian(nr%dr,dr);
            return;
        }

        int n = dr/nr+1;
        System.out.print("1/"+ n);
        int num = nr*n-dr;
        int den= dr*n;

        if(num!=0){
            System.out.print(" + ");
            printEgyptian(num,den);
        }
    }
    public static void main(String[] args) {
        int nr = 6, dr = 14;  // Example fraction

        // Calling the function to print the Egyptian Fraction Representation
        System.out.print("Egyptian Fraction Representation of " + nr + "/" + dr + " is:\n");
        printEgyptian(nr, dr);
    }
}

package com.kunal.Dsa.Strings;

public class KarpRabin {
    private final int PRIME = 101;
    private final int q = 1000000007;
    private long calculateHash(String str, int patternLength) {
        long hash =0;
        for (int i = 0; i < patternLength; i++) {
            hash=(hash*PRIME+str.charAt(i))%q;
        }
        return hash;
    }
    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
       long h=1;
        for (int i = 0; i < patternLength-1; i++) {
            h=(h*PRIME)%q;
        }
        long newhash= ((prevHash-oldChar*h)*PRIME+newChar)%q;
        if(newhash<0) newhash=(newhash+q)%q;
        return newhash;
    }
    public void search(String T, String P) {
        int n= T.length();
        int m= P.length();
        long patternhash = calculateHash(P,m);
        long texthash = calculateHash(T,m);
        for (int i = 0; i <= n-m; i++) {
            if(patternhash==texthash){
                if(T.substring(i,i+m).equals(P)){
                    System.out.println("Patten found at index"+i);
                }
            }
            if(i<n-m){
                texthash = updateHash(texthash,T.charAt(i),T.charAt(i+m),m);
            }
        }
    }
    public static void main(String[] args) {
        KarpRabin kr = new KarpRabin();
        String T = "AABAACAADAABAABA";
        String P = "AABA";

        kr.search(T, P);
    }
}

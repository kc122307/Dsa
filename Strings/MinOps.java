package com.kunal.Dsa.Strings;

public class MinOps {
    public static int minOps(String A, String B){
      if(A.length()!=B.length()){
          return -1;
      }
      int res=0;
      int i,j;
      int count [] = new int[256];
        for ( i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }
        for ( i = 0; i < 256; i++) {
            if (count[i]!=0){
                return -1;
            }
        }
        i=A.length()-1;
        j=B.length()-1;
        while(i>=0){
            if(A.charAt(i)==B.charAt(j)){
                j--;
            }
            else {
                res++;
            }
            i--;
        }
        return res;
    }
    public static void main(String[] args) {
        String A = "EACBD";
        String B = "EABCD";

        System.out.println(
                "Minimum number of operations required is "
                        + minOps(A, B));
    }
}

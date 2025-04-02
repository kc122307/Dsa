package com.kunal.Dsa.Sorting_Searching;

public class MedianOf2Array {
    static double medianOf2(int[] a, int[] b) {
       int n = a.length,m=b.length;
       if(n>m){
           return medianOf2(b,a);
       }
       int lo= 0,hi=n;
       while(lo<=hi){
           int mid1=(hi+lo)/2;
           int mid2=(n+m+1)/2 - mid1;

           int l1 = (mid1==0)?Integer.MIN_VALUE:a[mid1-1];
           int r1 = (mid1==n)?Integer.MAX_VALUE:a[mid1];

           int l2 =(mid2==0)?Integer.MIN_VALUE:b[mid2-1];
           int r2 =(mid2==m)?Integer.MAX_VALUE:b[mid2];

           if(l1<=r2&&l2<=r1){
               if(n%2==0){
                   return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
               }
               else {
                   return Math.max(l1,l2);
               }
           }
           else if (l1>r2) {
               hi=mid1-1;
           }
           else{
               lo=mid1+1;
           }
       }
       return 0;
    }
    public static void main(String[] args) {
        int[] a = {1, 12, 15, 26, 38};
        int[] b = {2, 13, 17, 30, 45, 60};

        System.out.println(medianOf2(a, b));
    }
}

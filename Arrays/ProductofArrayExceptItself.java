package com.kunal.Dsa.Arrays;

public class ProductofArrayExceptItself {
    static int[] product(int [] arr){
      int n= arr.length;
      int [] ans = new int[n];
      ans[0] =1;

      for (int i = 1; i < n; i++) {
          ans[i]=ans[i-1]*arr[i-1];
      }

      int suffix=1;

      for (int i = n-2; i>=0; i--) {
          suffix*=arr[i+1];
          ans[i]*=suffix;
      }
      return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] res = product(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}

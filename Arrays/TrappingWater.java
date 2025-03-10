package com.kunal.Dsa;

public class TrappingWater {
    static int Maxwater(int [] arr){
        int left=1;
        int right = arr.length-2;
        int lmax = arr[left-1];
        int rmax = arr[right+1];
        int res = 0;
        while(left<=right){
            if(rmax<lmax){
                res += Math.max(0 , rmax-arr[right]);

                rmax = Math.max(rmax , arr[right]);

                right -= 1;
            }
            else {
                res += Math.max(0 , lmax-arr[left]);

                lmax = Math.max(lmax , arr[left]);

                left += 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 1, 0, 4};
        System.out.println(Maxwater(arr));
    }
}

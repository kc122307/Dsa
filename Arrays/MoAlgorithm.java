package com.kunal.Dsa;

public class MoAlgorithm {
    static int query(int [] arr,int [] blocks,int l,int r,int sqrt ){
        int ans =0;
        while(l<=r && l%sqrt != 0){
            ans+=arr[l];
            l++;
        }
        while(l+sqrt-1<=r){
            ans+=blocks[l/sqrt];
            l+=sqrt;
        }
        while(l<=r){
            ans+=arr[l];
            l++;
        }
        return ans;
    }
    static void update(int arr[],int [] blocks,int i,int val,int sqrt){
        int block_id = i/sqrt;
        blocks[block_id] += val-arr[i];
        arr[i]= val;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int l = 0, r = 9;
        int n= arr.length;
        if(n==0){
            System.out.println("Empty");
            return;
        }
        int block_id = -1;
        int sqrt = (int) Math.sqrt(n);
        int [] blocks = new int[sqrt+1];
        for (int i = 0; i < n; i++) {
            if(i%sqrt==0){
                block_id++;
            }
            blocks[block_id]+= arr[i];
        }
        // Query entire array (should return 40)
        System.out.println("Sum from index 0 to 9: " + query(arr, blocks, l, r, sqrt)); // Expected: 40
        // Update index 3 to 10
        update(arr, blocks, 3, 10, sqrt);
        System.out.println("After updating index 3 to 10, sum from index 0 to 9: " + query(arr, blocks, l, r, sqrt)); // Expected: 48

    }
}

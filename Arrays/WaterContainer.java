package com.kunal.Dsa;

public class WaterContainer {
    static int maxArea(int[] arr) {
        int n = arr.length;
        int area = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int w = r - l;
            int h = Integer.min(arr[l], arr[r]);
            area = Integer.max(area, h * w);
            if(arr[l] < arr[r])  {
                l++ ;
            }
            else {
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + maxArea(heights));
    }
}

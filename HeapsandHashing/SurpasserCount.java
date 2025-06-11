package com.kunal.Dsa.HeapsandHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurpasserCount {
    static class Element{
        int value;
        int index;
        Element(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    public static int[] findSurpasserCount(int[] arr) {
        int n = arr.length;
        int [] result = new int[n];
        Element[] elements=new Element[n];

        for (int i = 0; i < n; i++) {
            elements[i]=new Element(arr[i],i);
        }
        mergeSort(elements,0,n-1,result);
        return result;
    }

    private static void mergeSort(Element[] arr, int left, int right, int[] result) {
        if(left>=right) return;

        int mid=left+(right-left)/2;
        mergeSort(arr,0,mid,result);
        mergeSort(arr,mid+1,right,result);
        merge(arr,0,mid,right,result);
    }

    private static void merge(Element[] arr, int left, int mid, int right, int[] result) {
        List<Element> merged = new ArrayList<>();
        int i=left,j=mid+1;
        int counter =0;

        while(i<=mid&&j<=right){
            if(arr[i].value<arr[j].value){
                counter++;
                merged.add(arr[j++]);
            }
            else {
                result[arr[i].index]+=counter;
                merged.add(arr[i++]);
            }
        }

        while(i<=mid){
            result[arr[i].index]+=counter;
            merged.add(arr[i++]);
        }

        while (j<=right){
            merged.add(arr[j++]);
        }

        for (int k = left; k <=right; k++) {
            arr[k]=merged.get(k-left);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 5, 3, 8, 1};
        System.out.println(Arrays.toString(findSurpasserCount(arr1))); // Output: [4, 1, 1, 1, 0, 0]

        int[] arr2 = {4, 5, 1};
        System.out.println(Arrays.toString(findSurpasserCount(arr2))); // Output: [1, 0, 0]
    }
}

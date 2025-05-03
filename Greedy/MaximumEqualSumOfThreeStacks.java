package com.kunal.Dsa.Greedy;

import java.util.ArrayList;
import java.util.List;

public class MaximumEqualSumOfThreeStacks {

    public static int maxEqualSum(List<Integer> s1, List<Integer> s2, List<Integer> s3) {
        int sum1=0,sum2=0,sum3=0;

        for (int i = 0; i <s1.size() ; i++) {
            sum1+=s1.get(i);
        }
        for (int i = 0; i <s2.size() ; i++) {
            sum2+=s2.get(i);
        }
        for (int i = 0; i <s3.size() ; i++) {
            sum3+=s3.get(i);
        }

        int i=0,j=0,k=0;

        while(true){
            if(i==s1.size()||j==s2.size()||k==s3.size()){
                return 0;
            }
            if(sum1==sum2&&sum1==sum3){
                return sum1;
            }
            if(sum1>sum2&&sum1>sum3){
                sum1-=s1.get(i++);
            }
            else if (sum2>sum1&&sum2>sum3) {
                sum2-=s2.get(j++);
            }
            else {
                sum3-=s3.get(k++);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> s1 = new ArrayList<>();
        s1.add(3);
        s1.add(2);
        s1.add(1);
        s1.add(1);
        s1.add(1);

        List<Integer> s2 = new ArrayList<>();
        s2.add(4);
        s2.add(3);
        s2.add(2);

        List<Integer> s3 = new ArrayList<>();
        s3.add(1);
        s3.add(1);
        s3.add(4);
        s3.add(1);

        System.out.println(maxEqualSum(s1, s2, s3));
    }
}

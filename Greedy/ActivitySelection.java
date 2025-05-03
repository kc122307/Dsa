package com.kunal.Dsa.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    static class Activity{
        int start,finish;
        Activity(int start,int finish){
            this.start=start;
            this.finish=finish;
        }
    }

    public static int maxActivities(int[] start, int[] finish) {
       int n =start.length;
       List<Activity> activities = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            activities.add(new Activity(start[i],finish[i]));
        }

        activities.sort(Comparator.comparingInt(a->a.finish));

        int count=1;
        int lastIndex = activities.get(0).finish;

        for (int i = 1; i < n; i++) {
            if(activities.get(i).start>lastIndex){
                count++;
                lastIndex=activities.get(i).finish;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] finish1 = {2, 4, 6, 7, 9, 9};
        System.out.println("Maximum activities = " + maxActivities(start1, finish1)); // Output: 4

        int[] start2 = {10, 12, 20};
        int[] finish2 = {20, 25, 30};
        System.out.println("Maximum activities = " + maxActivities(start2, finish2)); // Output: 1
    }
}

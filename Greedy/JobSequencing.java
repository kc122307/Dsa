package com.kunal.Dsa.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Job {
   int deadline , profit;
   Job(int deadline,int profit){
       this.deadline=deadline;
       this.profit=profit;
   }
}
public class JobSequencing {
    public static int[] jobScheduling(int[] deadlines, int[] profits) {
        int n = deadlines.length;
        List <Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(deadlines[i],profits[i]));
        }

        jobs.sort((a,b)-> b.profit-a.profit);

        int maxdeadline =0;
        for (Job job:jobs) {
            maxdeadline=Math.max(maxdeadline,job.deadline);
        }

        boolean [] slot = new boolean[maxdeadline+1];
        int maxprofit=0,jobcount=0;
        for (Job job:jobs) {
            for (int i = job.deadline; i>0; i--) {
                if(!slot[i]){
                    slot[i]=true;
                    jobcount++;
                    maxprofit+=job.profit;
                    break;
                }
            }
        }
        return new int[]{jobcount,maxprofit};
    }
    public static void main(String[] args) {
        int[] deadline1 = {4, 1, 1, 1};
        int[] profit1 = {20, 10, 40, 30};

        int[] result1 = jobScheduling(deadline1, profit1);
        System.out.println("Output: " + result1[0] + " " + result1[1]);

        int[] deadline2 = {2, 1, 2, 1, 1};
        int[] profit2 = {100, 19, 27, 25, 15};

        int[] result2 = jobScheduling(deadline2, profit2);
        System.out.println("Output: " + result2[0] + " " + result2[1]);
    }
}

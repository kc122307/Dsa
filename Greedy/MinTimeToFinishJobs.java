package com.kunal.Dsa.Greedy;

public class MinTimeToFinishJobs {

    // This function checks if it's possible to complete all jobs with k assignees and maxTime
    static boolean canCompleteJobs(int[] job, int k, int maxTime) {
        int currentTime = 0;  // Tracks the time for the current assignee
        int assignes = 1;     // We start with one assignee

        for (int i = 0; i < job.length; i++) {
            // If adding the current job exceeds the max time, assign the job to a new worker
            if (currentTime + job[i] > maxTime) {
                assignes++;       // Assign a new worker
                currentTime = job[i];  // Assign the current job to the new worker
                if (assignes > k) { // If we exceed the available number of workers
                    return false;
                }
            } else {
                currentTime += job[i];  // Add the job time to the current worker
            }
        }
        return true; // All jobs can be completed within the maxTime
    }

    // This function calculates the minimum time to finish all jobs with k assignees
    static int minTimeToFinishJobs(int[] job, int k) {
        int left = 0;
        int right = 0;

        // Calculate the maximum time a single job can take (left) and total time (right)
        for (int j : job) {
            right += j;  // Sum of all job times
            left = Math.max(left, j);  // Maximum single job time
        }

        // Binary search to find the minimum feasible time
        while (left < right) {
            int mid = (left + right) / 2;

            // If it's possible to finish all jobs within `mid` time, try to minimize further
            if (canCompleteJobs(job, k, mid)) {
                right = mid;  // We can minimize further, so move the upper bound to mid
            } else {
                left = mid + 1;  // Otherwise, increase the lower bound
            }
        }

        // The minimum time is found when left == right
        return left;
    }

    public static void main(String[] args) {
        // Example 1
        int[] job1 = {10, 7, 8, 12, 6, 8};
        int k1 = 4;
        System.out.println(minTimeToFinishJobs(job1, k1));  // Expected Output: 23

        // Example 2
        int[] job2 = {4, 5, 10};
        int k2 = 2;
        System.out.println(minTimeToFinishJobs(job2, k2));  // Expected Output: 10
    }
}

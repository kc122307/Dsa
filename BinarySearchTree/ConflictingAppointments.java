package com.kunal.Dsa.BinarySearchTree;

class Interval{
    int start,end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}
public class ConflictingAppointments {
    static void findConflicts(Interval[] appts) {
        for (int i = 1; i <appts.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(doOverlap(appts[i],appts[j])){
                    System.out.println("[" + appts[i].start + "," + appts[i].end + "] Conflicts with [" + appts[j].start + "," + appts[j].end + "]");;
                    break;
                }
            }
        }
    }
    static boolean doOverlap(Interval a, Interval b) {
        return (a.start<b.end&&b.start< a.end);
    }
    public static void main(String[] args) {
        Interval[] appts = {
                new Interval(1, 5),
                new Interval(3, 7),
                new Interval(2, 6),
                new Interval(10, 15),
                new Interval(5, 6),
                new Interval(4, 100)
        };

        findConflicts(appts);
    }
}

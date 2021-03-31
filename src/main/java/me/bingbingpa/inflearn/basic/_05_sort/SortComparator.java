package me.bingbingpa.inflearn.basic._05_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortComparator {
    /**===================Example===================
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * before.end >= cur.start
     * before.end = Math.max(curr.end, before.end);
     */
    public static void main(String[] args) {
        Interval in1 = new Interval(1, 3);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        List<Interval> list = merge(intervals);
        print(list);

    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        // sorting
//        intervals.sort(comp);
//        intervals.sort(comparingInt(a -> a.start));
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        Interval before = intervals.get(0);
        for (Interval curr : intervals) {
            if (before.end >= curr.start) {
                before.end = Math.max(curr.end, before.end);
            } else {
                result.add(before);
                before = curr;
            }
        }

        // 마지막꺼 넣어주기
        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    Comparator<Interval> comp = new Comparator<Interval>() {

        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };

    public static void print(List<Interval> list) {
        for (Interval in : list) {
            System.out.println(in.start + " " + in.end);
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

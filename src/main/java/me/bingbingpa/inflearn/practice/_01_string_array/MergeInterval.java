package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        Interval in2 = new Interval(2, 6);
        Interval in1 = new Interval(1, 3);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        List<Interval> result = mergeInterval.solution(intervals);
        mergeInterval.print(result);
    }

    /**
     * TODO 주어진 배열에서 겹치는 부분을 리턴하라. 겹치지 않는 부분은 그대로 리턴.
     * 예) input: [[1,3],[2,6],[8,10],[15,18]], output: [[1,6],[8,10],[15,18]]
     */
    public List<Interval> solution(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        // 정렬
        intervals.sort((a, b) -> a.start - b.start);
        Interval before = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    private void print(List<Interval> list) {
        for (int i = 0; i < list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start + " " + in.end);
        }
    }

    private static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

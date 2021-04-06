package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        MeetingRoom2 meetingRoom2 = new MeetingRoom2();

        Interval in3 = new Interval(0, 30);
        Interval in1 = new Interval(4, 9);
        Interval in4 = new Interval(10, 16);
        Interval in2 = new Interval(5, 15);

        Interval[] intervals = {in1, in2, in3, in4};
        System.out.println("result ===================== " + meetingRoom2.solution(intervals));
    }

    /**
     * TODO 시작 및 종료로 구성된 일련의 회의 시간 간격이 주어졌을 때 필요한 최소의 회의실 수를 구하라.
     * [[s1, e1], [s2, e2], ...] (si <ei)
     * 예) input: [[0,30],[4,9],[5,15],[10,16]], output: 3
     */
    public int solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        Queue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek().end <= intervals[i].start) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }

        return pq.size();
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

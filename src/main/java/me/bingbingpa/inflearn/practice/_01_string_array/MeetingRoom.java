package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();
        Interval in1 = new Interval(15, 20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);

        Interval[] intervals = {in1, in2, in3};
        System.out.println("result ==============  " + meetingRoom.solve(intervals));
    }

    /**
     * TODO 주어진 Interval 클래스의 시작 종료값이 겹치는지 판별하라.
     * 예) [[0,30],[5,10],[15,20]]   => false
     * 예) [[7,10],[2,4]]   => true
     */
    private boolean solve(Interval[] intervals) {
        // null 체크
        if (intervals == null) {
            return false;
        }
        // 정렬
        Arrays.sort(intervals, Comparator.comparing(a -> a.start));
        print(intervals);

        // 반복
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }

        return true;
    }

    private void print(Interval[] intervals) {
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    private static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
}

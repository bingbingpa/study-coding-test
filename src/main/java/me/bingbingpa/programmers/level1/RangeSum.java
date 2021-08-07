package me.bingbingpa.programmers.level1;

import java.util.stream.LongStream;

public class RangeSum {
    public static void main(String[] args) {
        RangeSum T = new RangeSum();
        System.out.println(T.solution(3, 5)); //12
    }

    /**
     * 두 정수 사이의 합
     * https://programmers.co.kr/learn/courses/30/lessons/12912
     */
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return LongStream.rangeClosed(min, max).sum();
    }
}

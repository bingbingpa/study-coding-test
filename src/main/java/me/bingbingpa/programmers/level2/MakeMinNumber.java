package me.bingbingpa.programmers.level2;

import java.util.Arrays;

public class MakeMinNumber {

    public static void main(String[] args) {
        MakeMinNumber T = new MakeMinNumber();
        System.out.println(T.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }

    /**
     * 최솟값 만들기
     * https://programmers.co.kr/learn/courses/30/lessons/12941
     */
    public int solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[a.length - 1 - i];
        }
        return answer;
    }
}

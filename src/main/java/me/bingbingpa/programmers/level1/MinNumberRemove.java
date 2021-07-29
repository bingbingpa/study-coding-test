package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class MinNumberRemove {
    public static void main(String[] args) {
        MinNumberRemove T = new MinNumberRemove();
        System.out.println(Arrays.toString(T.solution(new int[]{4, 3, 2, 1})));
    }

    /**
     * TODO 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
     * https://programmers.co.kr/learn/courses/30/lessons/12935
     */
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr)
                .filter(i -> i != min)
                .toArray();
    }
}

package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class DivisibleNumbers {

    public static void main(String[] args) {
        DivisibleNumbers T = new DivisibleNumbers();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 9, 7, 10}, 5))); //[5,10]
    }

    /**
     * 나누어 떨어지는 숫자 배열
     * https://programmers.co.kr/learn/courses/30/lessons/12910
     */
    public Integer[] solution(int[] arr, int divisor) {
        Integer[] answers = Arrays.stream(arr)
                .filter(n -> n % divisor == 0)
                .sorted()
                .boxed()
                .toArray(Integer[]::new);

        return answers.length == 0 ? new Integer[]{-1} : answers;
    }
}

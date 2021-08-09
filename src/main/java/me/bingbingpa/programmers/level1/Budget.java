package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        Budget T = new Budget();
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5}, 9)); //3
    }

    /**
     * 예산 구하기
     * https://programmers.co.kr/learn/courses/30/lessons/12982
     */
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int money : d) {
            budget -= money;
            if (budget < 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}

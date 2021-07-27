package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class LottoPrediction {
    public static void main(String[] args) {
        LottoPrediction lottoPrediction = new LottoPrediction();
        int[] lotto = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        System.out.println("result ============= " + Arrays.toString(lottoPrediction.solution(lotto, winNums))); // [3,5]
    }

    /**
     * TODO 로또의 최고 순위와 최저 순위
     * https://programmers.co.kr/learn/courses/30/lessons/77484
     */
    private int[] solution(int[] lottos, int[] winNums) {
        int cnt = 0;
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
                continue;
            }
            for (int win_num : winNums) {
                if (win_num == lotto) {
                    cnt++;
                    break;
                }
            }
        }
        return new int[]{7 - Math.max(cnt + zeroCnt, 1), 7 - Math.max(cnt, 1)};
    }
}

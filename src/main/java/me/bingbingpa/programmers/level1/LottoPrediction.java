package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class LottoPrediction {
    public static void main(String[] args) {
        LottoPrediction lottoPrediction = new LottoPrediction();
        int[] lotto = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        System.out.println("result ============= " + Arrays.toString(lottoPrediction.solution(lotto, winNums))); // [3,5]
    }

    private int[] solution(int[] lotto, int[] winNums) {
        int MATCH_COUNT = 6;
        int zeroCount = 0;
        int success = 0;
        for (int inputNum : lotto) {
            if (inputNum == 0) {
                zeroCount++;
            } else {
                for (int winNum : winNums) {
                    if (winNum == inputNum) {
                        success++;
                    }
                }
            }
        }
        int maxRank = MATCH_COUNT - (success + zeroCount) + 1;
        int minRank = success <= 1 ? MATCH_COUNT : MATCH_COUNT - success + 1;

        return new int[]{maxRank, minRank};

    }
}

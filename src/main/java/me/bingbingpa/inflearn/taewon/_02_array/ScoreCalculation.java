package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class ScoreCalculation {
//    public static void main(String[] args) {
//        ScoreCalculation T = new ScoreCalculation();
//        int[] nums = new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
//        System.out.println(T.mySolution(nums));
//    }

    public static void main(String[] args) {
        ScoreCalculation T = new ScoreCalculation();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(T.mySolution(nums));
    }

    /**
     * TODO 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산할 때 총 점수를 구하라.
     */
    public int mySolution(int[] nums) {
        int answer = 0;
        int weight = 0;
        for (int num : nums) {
            if (num == 1) {
                weight++;
            } else {
                weight = 0;
            }
            answer += weight;
        }

        return answer;
    }
}

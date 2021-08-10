package me.bingbingpa.programmers.level1;

public class MutualEvaluation {

    public static void main(String[] args) {
        MutualEvaluation T = new MutualEvaluation();
        int[][] score = new int[][]{
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        };
        System.out.println(T.solution(score));
    }

    /**
     * 상호 평가
     * https://programmers.co.kr/learn/courses/30/lessons/83201
     */
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        int len = scores.length;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int maxCount = 0;
            int minCount = 0;
            for (int[] ints : scores) {
                int score = ints[i];
                System.out.println("score = " + score);
                sum += score;
                min = Math.min(min, score);
                max = Math.max(max, score);
            }
            for (int[] score : scores) {
                if (score[i] == max) {
                    maxCount++;
                }
                if (score[i] == min) {
                    minCount++;
                }
            }
            int target = scores[i][i];
            int divide = len;
            if (target == max && maxCount == 1) {
                sum -= max;
                divide-=1;
            }
            if (target == min && minCount == 1) {
                sum -= min;
                divide-=1;
            }
            answer.append(getGrade(sum / divide));
            System.out.println("sum = " + sum);
            System.out.println("getGrade(sum/len) = " + getGrade(sum / divide));
        }

        return answer.toString();
    }

    private String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}

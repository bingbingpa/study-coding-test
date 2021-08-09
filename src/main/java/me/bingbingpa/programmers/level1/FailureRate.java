package me.bingbingpa.programmers.level1;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
        FailureRate T = new FailureRate();
        System.out.println(Arrays.toString(T.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}))); // [3,4,2,1,5]
    }

    /**
     * 실패율 구하기
     * https://programmers.co.kr/learn/courses/30/lessons/42889
     */
    public int[] solution(int N, int[] stages) {
        List<Stage> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int now = 0;
            int clear = 0;

            for (int stage : stages) {
                if (i <= stage) {
                    clear += 1;
                }
                if (i == stage) {
                    now += 1;
                }
            }
            if (clear == 0) {
                answer.add(new Stage(i, 0));
            } else {
                answer.add(new Stage(i, (double) now / clear));
            }
        }

        answer.sort(Stage::compareTo);

        return answer.stream().mapToInt(Stage::getNum).toArray();
    }

    static class Stage implements Comparable<Stage> {
        private final int num;
        private final double failure;

        public Stage(int num, double failure) {
            this.num = num;
            this.failure = failure;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failure == o.failure) {
                return this.num < o.num ? -1 : 1;
            } else {
                return this.failure > o.failure ? -1 : 1;
            }
        }
    }
}

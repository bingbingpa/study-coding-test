package me.bingbingpa.programmers.level1;

import java.util.*;

public class MockTest {

    public static void main(String[] args) {
        MockTest T = new MockTest();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 2})));
    }

    /**
     * TODO 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     * https://programmers.co.kr/learn/courses/30/lessons/42840
     */
    public int[] solution(int[] answers) {
        List<Integer> result = new ArrayList<>();
        int[][] students = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5, 2, 1},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < students.length; i++) {
            int count = 0;
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == students[i][j]) {
                    count++;
                }
                map.put(i, count);
                max = Math.max(max, count);
            }
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == max) {
                result.add(num + 1);
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] answer(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                score[0]++;
            }
            if (answers[i] == b[i % b.length]) {
                score[1]++;
            }
            if (answers[i] == c[i % c.length]) {
                score[2]++;
            }
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if (maxScore == score[0]) {
            list.add(1);
        }
        if (maxScore == score[1]) {
            list.add(2);
        }
        if (maxScore == score[2]) {
            list.add(3);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

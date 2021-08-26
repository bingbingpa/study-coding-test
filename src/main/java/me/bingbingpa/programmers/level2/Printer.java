package me.bingbingpa.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public static void main(String[] args) {
        Printer T = new Printer();
        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
    }

    /**
     * 프린터
     * https://programmers.co.kr/learn/courses/30/lessons/42587
     */
    public int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for (int task : priorities) {
            priority.add(task);
        }

        while (!priority.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priority.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    priority.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}

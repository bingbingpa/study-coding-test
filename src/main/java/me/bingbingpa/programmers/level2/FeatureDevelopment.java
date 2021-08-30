package me.bingbingpa.programmers.level2;

import java.util.*;

public class FeatureDevelopment {

    public static void main(String[] args) {
        FeatureDevelopment T = new FeatureDevelopment();
        System.out.println(T.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    /**
     * 기능 개발
     * https://programmers.co.kr/learn/courses/30/lessons/42586
     */
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!queue.isEmpty() && queue.peek() < date) {
                result.add(queue.size());
                queue.clear();
            }
            queue.offer(date);
        }

        result.add(queue.size());

        return result;
    }
}

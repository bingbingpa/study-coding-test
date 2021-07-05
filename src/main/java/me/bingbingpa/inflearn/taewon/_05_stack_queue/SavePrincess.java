package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SavePrincess {
//    public static void main(String[] args) {
//        SavePrincess T = new SavePrincess();
//        System.out.println(T.solution(8, 3));
//    }

    public static void main(String[] args) {
        SavePrincess T = new SavePrincess();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(T.solution(n, k));
    }

    /**
     * TODO N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
     */
    public int solution(int n, int k) {
        int answer = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.poll();
            }
        }

        return answer;
    }
}

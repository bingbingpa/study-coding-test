package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CalfSearch {
    public static void main(String[] args) {
        CalfSearch T = new CalfSearch();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println(T.solution(s, e));
    }

    /**
     * TODO 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
     * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
     */
    public int solution(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = {1, -1, 5};
        int[] ch = new int[10001];
        int level = 1;
        queue.add(start);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int num = queue.poll();
                for (int k : dist) {
                    int point = num + k;
                    if (point == end) {
                        return level;
                    }
                    if (point >= 1 && point <= 10000 && ch[point] == 0) {
                        ch[point] = 1;
                        queue.add(point);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

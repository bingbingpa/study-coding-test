package me.bingbingpa.inflearn.taewon._08_dfs_bfs_practice;

import java.util.Scanner;

public class MaxScore {

    static int n, m, answer = 0;
    public static void main(String[] args) {
        MaxScore T = new MaxScore();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        T.dfs(0, 0, 0, a, b);
        System.out.println(answer);
    }

    /**
     * TODO 제한시간 M안에 N개의 문제 중 최대점수를 구하라.
     */
    public void dfs(int level, int sum, int time, int[] ps, int[] pt) {
        if (time > m) {
            return;
        }
        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + ps[level], time + pt[level], ps, pt);
            dfs(level + 1, sum, time, ps, pt);
        }
    }
}

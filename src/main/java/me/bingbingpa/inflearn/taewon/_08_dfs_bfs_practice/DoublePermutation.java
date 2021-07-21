package me.bingbingpa.inflearn.taewon._08_dfs_bfs_practice;

import java.util.Scanner;

public class DoublePermutation {

    static int[] pm;
    static int n,m;
    public static void main(String[] args) {
        DoublePermutation T = new DoublePermutation();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];
        T.dfs(0);
    }

    /**
     * TODO 1부터 N 까지 번호가 적힌 구슬이 있을 때, 이 중 중복을 허락하려 M 번을 뽑아 일렬로 나열하는 방법을 모두 출력하라.
     */
    public void dfs(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.printf(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[level] = i;
                dfs(level + 1);
            }
        }
    }
}

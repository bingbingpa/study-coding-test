package me.bingbingpa.inflearn.taewon._08_dfs_bfs_practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        CoinExchange T = new CoinExchange();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = scanner.nextInt();
        T.dfs(0, 0, arr);
        System.out.println(answer);
    }

    /**
     * TODO 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주는 프로그램을 작성하세요.
     */
    public void dfs(int level, int sum, Integer[] arr) {
        if (sum > m || level >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(level + 1, sum + arr[i], arr);
            }
        }
    }
}

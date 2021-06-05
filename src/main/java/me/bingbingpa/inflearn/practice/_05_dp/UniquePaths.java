package me.bingbingpa.inflearn.practice._05_dp;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println("result ========= " + solution(7, 3)); // 28
    }

    /**
     * TODO m*n 의 그리드가 주어졌을때 오른쪽 하단 모서리에 도달할 수 있는 경로를 구하라.
     * input: m=3, n=2 output: 3
     * input: m=7, n=3 output: 28
     */
    public static int solution(int m, int n) {
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }

        return map[m-1][n-1];
    }
}

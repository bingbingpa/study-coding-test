package me.bingbingpa.baekjoon;

public class ZRecursive {
    private static int count;
    private static int N = 3;
    private static int r = 7;
    private static int c = 7;
    public static void main(String[] args) {
        solution((int) Math.pow(2, N), 0, 0); // output: 11
    }

    /**
     * TODO N 이 주어 졌을 때 2N * 2N 배열 모양을 탐색했을 때,  r 행 c 열을 몇번째로 방문했는지 출력하라.
     * (https://www.acmicpc.net/problem/1074)
     * N > 1이 라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문
     * 제한: 1 ≤ N ≤ 15, 0 ≤ r, c < 2N
     */
    static void solution(int n, int y, int x) {
        if (y == r && x == c) {
            System.out.println(count);
            System.exit(0);
        }

        if (y <= r && r < (y + n) && x <= c && c < (x + n)) {
            int nn = n / 2;
            solution(nn, y, x);
            solution(nn, y, x + nn);
            solution(nn, y + nn, x);
            solution(nn, y + nn, x + nn);
        } else {
            count += n * n;
        }
    }
}

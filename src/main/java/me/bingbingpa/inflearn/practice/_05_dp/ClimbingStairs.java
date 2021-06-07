package me.bingbingpa.inflearn.practice._05_dp;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("result =============== " + solution(4)); //output: 5
    }

    /**
     * TODO 1칸 또는 2칸씩 이동하여 주어진 n 개의 계단을 오를 수 있는 모든 수를 구하라.
     */
    public static int solution(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

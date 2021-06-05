package me.bingbingpa.inflearn.practice._05_dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println("result ============= " + solution(new int[]{1, 2, 5}, 11));
    }

    /**
     * TODO 다른 종류의 동전과 총 금액이 주어졌을 때 금액을 만족하는 최소 코인 수를 리턴하라.
     * input: coins = [1, 2, 5], amount = 11  -> output: 3
     */
    public static int solution(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

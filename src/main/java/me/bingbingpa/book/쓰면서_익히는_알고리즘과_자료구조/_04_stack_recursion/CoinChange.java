package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._04_stack_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(solution(new ArrayList<>(Arrays.asList(1, 2, 5)), 11)); // 3개 ([5,5,1])
    }

    /**
     * 입력 받은 동전의 값 배열로 주어진 돈을 가장 적은 개수의 동전으로 반환하라.
     */
    public static int solution(List<Integer> coins, int value) {
        return change(coins, value);
    }

    private static int change(List<Integer> coins, int v) {
        if (v == 0) {
            return 0;
        }
        int minCoinCnt = Integer.MAX_VALUE;
        for (Integer c : coins) {
            if ((v - c) >= 0) {
                int changeCnt = change(coins, v - c);
                if (changeCnt < minCoinCnt) {
                    minCoinCnt = changeCnt;
                }
            }
        }
        return minCoinCnt+1;
    }
}

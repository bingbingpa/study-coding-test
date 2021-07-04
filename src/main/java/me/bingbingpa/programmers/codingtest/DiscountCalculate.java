package me.bingbingpa.programmers.codingtest;

import java.util.Arrays;

public class DiscountCalculate {
    public static void main(String[] args) {
        DiscountCalculate T = new DiscountCalculate();
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20};

        System.out.println(T.solution(prices, discounts));  //82000
    }

    /**
     * 할인율 게산하기
     */
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int pricesIndex = prices.length - 1;
        int discountIndex = discounts.length - 1;
        for (int i = pricesIndex; i >= 0; i--) {
            if (discountIndex < 0) {
                answer += prices[i];
            } else {
                answer += prices[i] - (prices[i] * (discounts[discountIndex] * 0.01));
            }
            discountIndex--;
        }

        return answer;
    }
}

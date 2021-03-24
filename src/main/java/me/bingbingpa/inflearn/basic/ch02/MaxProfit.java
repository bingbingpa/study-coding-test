package me.bingbingpa.inflearn.basic.ch02;

public class MaxProfit {
    /**
     * ===================Problem===================
     * - i번째 요소가 i 일에 주어진 주식의 가격 인 배열이 있다고 가정합니다 .
     * - 최대 한번의 거래만 완료하도록 허용 된 경우
     * (즉, 주식을 하나 사고, 한 주식을 매도)
     * 최대 수익을 찾는 알고리즘을 설계하십시오.
     * - 주식을 구입하기 전에는 주식을 팔 수 없습니다.
     * ===================Example===================
     * 입력 : { 8, 2, 6, 5, 1,7, 5 }
     * 출력 : 6
     * 설명 : 5 일에 구매 (가격 = 1), 6 일에 판매 (가격 = 7), 이익 = 7-1 = 6
     */

    public static void main(String[] args) {
        int[] prices = {8, 2, 6, 5, 1, 7, 5};
        System.out.println("result ================== " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int sofaMin = prices[0];
        for (int price : prices) {
            if (price < sofaMin) {
                sofaMin = price;
            } else {
                max = Math.max(max, price - sofaMin);
            }
        }

        return max;
    }
}

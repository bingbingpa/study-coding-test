package me.bingbingpa.programmers.level1;

public class InsufficientCash {
    public static void main(String[] args) {
        InsufficientCash T = new InsufficientCash();
        System.out.println(T.solution(3, 20, 4)); //10
    }

    /**
     * 부족한 금액 채우기
     */
    public long solution(int price, int money, int count) {
//        int sum = (count * ((2 * price) + ((count - 1) * price))) / 2;
//        return money > sum ? money : sum - money;
        long totalPrice = (price * count * ((long)count + 1)) / 2;
        return (money >= totalPrice) ? 0 : totalPrice - money;
    }
}

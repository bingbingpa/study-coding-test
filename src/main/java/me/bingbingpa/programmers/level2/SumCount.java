package me.bingbingpa.programmers.level2;

public class SumCount {

    public static void main(String[] args) {
        SumCount T = new SumCount();
        System.out.println(T.solution(15)); // 4
    }

    /**
     * 숫자의 표현
     * https://programmers.co.kr/learn/courses/30/lessons/12924
     */
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum =0;
            for (int j = i; sum <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

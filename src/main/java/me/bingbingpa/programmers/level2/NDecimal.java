package me.bingbingpa.programmers.level2;

public class NDecimal {

    public static void main(String[] args) {
        NDecimal T = new NDecimal();
        System.out.println(T.solution(2, 4, 2, 1));
    }

    /**
     * N 진수 게임
     * https://programmers.co.kr/learn/courses/30/lessons/17687
     */
    public String solution(int n, int t, int m, int p) {
        int startNum = 0;

        StringBuilder targetString = new StringBuilder();
        StringBuilder retString = new StringBuilder();

        while (targetString.length() < m * t) {
            targetString.append(Integer.toString(startNum++, n));
        }
        for (int i = 0; i < t; i++) {
            retString.append(targetString.charAt(p - 1 + i * m));
        }

        return retString.toString().toUpperCase();
    }
}

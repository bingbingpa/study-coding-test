package me.bingbingpa.codeup.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("result ============ " + solution(5)); // output: 120
    }

    /**
     * TODO n 이 입력되면 n!의 값을 재귀를 이용하여 출력하라.
     * 자연수 n이 입력된다. (n<=12)
     */
    public static int solution(int num) {
        if (num < 1) {
            return 1;
        }
        return num * solution(num - 1);
    }
}

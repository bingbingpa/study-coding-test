package me.bingbingpa.codeup.basic100;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println("result ============== " + solution(3, 7, 9)); //output: 63
    }

    /**
     * TODO 같은 날 동시에 가입한 3명의 사람들이 온라인 채점시스템에 들어와 문제를 푸는 날짜가 매우 규칙적이라고 할 때, 다시 모두 함께 문제를 풀게 되는 날을 구해라.
     */
    public static int solution(int n1, int n2, int n3) {
        int day = 1;
        while (day % n1 != 0 || day % n2 != 0 || day % n3 != 0) {
            day++;
        }

        return day;
    }
}

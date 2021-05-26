package me.bingbingpa.codeup.recursion;

public class SumNumber {
    public static void main(String[] args) {
        System.out.println("result =========== " + solution(100)); // output: 5050
    }

    /**
     * TODO 정수 n이 입력으로 들어오면 1부터 n 까지의 합을 재귀를 이용하여 구하라.
     * 입력으로 자연수 n이 입력된다. (1<=n<=10,000)
     */
    public static int solution(int num) {
        return recursion(1, num);
    }

    static int sum = 0;
    private static int recursion(int start, int end) {
        if (start > end) {
            return sum;
        }
        sum += start;
        return recursion(start + 1, end);
    }
}

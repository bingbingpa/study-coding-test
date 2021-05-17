package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._04_stack_recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("result =========== " + solution(3)); // 3
    }

    /**
     * TODO 입력으로 주어지는 n 개의 계단을 1번에 1개 혹은 2개 올라 도달할 수 있는 방법의 가지수를 리턴하라.
     */
    public static int solution(int n) {
        return recursion(n, 0);
    }

    private static int recursion(int n, int i) {
        if (n == i) {
            return 1;
        }
        if (n < i) {
            return 0;
        }

        return recursion(n, i + 1) + recursion(n, i + 2);
    }
}

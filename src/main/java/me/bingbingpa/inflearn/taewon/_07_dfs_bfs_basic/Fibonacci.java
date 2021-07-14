package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class Fibonacci {

    private int[] fibo = new int[51];
    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        int n = 50;
        for (int i = 1; i <= n; i++) {
            System.out.printf(T.mySolution(i) +" ");
        }
    }

    /**
     * TODO 입력된 N 의 길이에 해당하는 피보나치 수열을 출력하는 프로그램을 작성하세요.
     */
    public int mySolution(int n) {
        if (n <= 2) {
            return 1;
        }
        if (fibo[n] != 0) {
            return fibo[n];
        }
        fibo[n] = mySolution(n - 2) + mySolution(n - 1);

        return fibo[n];
    }
}

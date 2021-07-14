package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class Factorial {

    public static void main(String[] args) {
        Factorial T = new Factorial();
        System.out.println(T.mySolution(5));
    }

    /**
     * TODO 자연수 N 이 입력되면 N! 를 구하는 프로그램을 작성하세요.
     */
    public int mySolution(int n) {
        if (n == 1) {
            return 1;
        }

        return n * mySolution(n - 1);
    }
}

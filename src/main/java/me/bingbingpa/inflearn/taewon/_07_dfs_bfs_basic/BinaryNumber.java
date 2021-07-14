package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class BinaryNumber {

    public static void main(String[] args) {
        BinaryNumber T = new BinaryNumber();
        T.mySolution(11);
    }

    /**
     * TODO 10진수 N 이 입력되면 2진수로 변환하여 출력하는 프로그램을 재귀함수로 작성하세요.
     */
    public void mySolution(int n) {
        if (n == 0) {
            return;
        }
        mySolution(n / 2);
        System.out.printf(n % 2 + " ");
    }
}

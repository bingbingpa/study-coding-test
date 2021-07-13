package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class Recursive {

    public static void main(String[] args) {
        Recursive T = new Recursive();
        T.mySolution(3);
    }

    /**
     * TODO 자연수 N 이 입력되면 재귀 함수를 이용하여 1부터 N 까지를 출력하는 프로그램을 작성하세요.
     */
    public void mySolution(int num) {
        if (num == 0) {
            return;
        }
        mySolution(num - 1);
        System.out.printf(num + " ");
    }
}

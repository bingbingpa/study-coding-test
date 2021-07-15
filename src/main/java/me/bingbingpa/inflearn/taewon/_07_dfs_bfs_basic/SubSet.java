package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class SubSet {
    private static int n;
    private static int[] ch;
    public static void main(String[] args) {
        SubSet T = new SubSet();
        n = 3;
        ch = new int[n + 1];
        T.dfs(1);
    }

    /**
     * TODO 자연수 N 이 주어지면 1부터 N 까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
     */
    public void dfs(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L + 1);
        }
    }
}

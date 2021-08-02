package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;


public class TrinaryDigit {
    public static void main(String[] args) {
        TrinaryDigit T = new TrinaryDigit();
        System.out.println(T.solution(125));
    }

    /**
     * 3진법 뒤집기
     * https://programmers.co.kr/learn/courses/30/lessons/68935
     */
    public int solution(int n) {
        String trinaryDigitNumber = recursive(n, 3, new StringBuilder());

        return Integer.parseInt(trinaryDigitNumber, 3);
    }

    private String recursive(int n, int divide, StringBuilder sb) {
        if (n == 0) {
            return "";
        }

        sb.append(n % divide);
        recursive(n / divide, divide, sb);

        return sb.toString();
    }
}

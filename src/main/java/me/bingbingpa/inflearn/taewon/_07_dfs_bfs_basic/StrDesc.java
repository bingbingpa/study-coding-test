package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

import java.util.Arrays;

public class StrDesc {
    public static void main(String[] args) {
        StrDesc T = new StrDesc();
        System.out.println(T.solution("Zbcdefg"));
    }

    /**
     * 문자열 내림차순으로 배치하기
     * https://programmers.co.kr/learn/courses/30/lessons/12917
     */
    public String solution(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new StringBuilder(new String(chars)).reverse().toString();
    }
}

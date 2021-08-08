package me.bingbingpa.programmers.level1;

public class CountOfPAndY {
    public static void main(String[] args) {
        CountOfPAndY T = new CountOfPAndY();
        System.out.println(T.solution("Pyy"));
    }

    /**
     * 문자열 내 p 와 y 의 개수
     * https://programmers.co.kr/learn/courses/30/lessons/12916
     */
    boolean solution(String s) {
        s = s.toUpperCase();

        return s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
    }
}

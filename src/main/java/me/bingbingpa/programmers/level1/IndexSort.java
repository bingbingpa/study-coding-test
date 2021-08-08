package me.bingbingpa.programmers.level1;

import java.util.*;

public class IndexSort {

    public static void main(String[] args) {
        IndexSort T = new IndexSort();
        System.out.println(Arrays.toString(T.solution(new String[]{"abce", "abcd", "cdx"}, 2))); //["abcd", "abce", "cdx"]
    }

    /**
     * 문자열 내 마음대로 정렬하기
     * https://programmers.co.kr/learn/courses/30/lessons/12915
     */
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Comparator<String> comparator = Collections.reverseOrder((s1, s2) -> s2.charAt(n) - s1.charAt(n));
        Arrays.sort(strings, comparator);

        return strings;
    }
}

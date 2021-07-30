package me.bingbingpa.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class NumberDescending {

    public static void main(String[] args) {
        NumberDescending T = new NumberDescending();
        System.out.println(T.solution2(118372));
    }

    /**
     * TODO 정수 내림차순으로 배치하기
     */
    public long solution(long n) {
        String strNumber = String.valueOf(n);
        char[] chars = strNumber.toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[chars.length - 1 - i]);
        }

        return Long.parseLong(sb.toString());
    }

    public long solution2(long n) {
        String strNumber = String.valueOf(n);
        String[] split = strNumber.split("");
        Arrays.sort(split, Collections.reverseOrder());
        String collect = String.join("", split);

        return Long.parseLong(collect);
    }
}

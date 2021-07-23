package me.bingbingpa.programmers.codingtest;

import java.util.Map;

public class NumberToString {
    public static void main(String[] args) {
        NumberToString numberToString = new NumberToString();
        System.out.println("result ============= " + numberToString.solution("one4seveneight"));
    }

    /**
     * TODO 입력 문자열을 숫자로 변환하여 리턴하라.
     */
    public int solution(String str) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );

        StringBuilder temp = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int target = ch - '0';
            if (target < 10) {
                sb.append(ch);
            } else {
                temp.append(ch);
            }
            if (map.containsKey(temp.toString())) {
                sb.append(map.get(temp.toString()));
                temp.setLength(0);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}

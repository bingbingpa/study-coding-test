package me.bingbingpa.programmers.level1;

import java.util.Map;

public class NumberToString {
    public static void main(String[] args) {
        NumberToString numberToString = new NumberToString();
        System.out.println("result ============= " + numberToString.answer("one4seveneight"));
    }

    /**
     * TODO 숫자 문자열과 영단어
     * https://programmers.co.kr/learn/courses/30/lessons/81301
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

    public int answer(String str) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i = 0; i < 10; i++) {
            str = str.replaceAll(alphabets[i], digits[i]);
        }

        return Integer.parseInt(str);
    }
}

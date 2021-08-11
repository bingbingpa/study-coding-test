package me.bingbingpa.programmers.level2;


public class JadenCase {

    public static void main(String[] args) {
        JadenCase T = new JadenCase();
        System.out.println(T.solution("3people unFollowed me"));
    }

    /**
     * JadenCase 문자열 만들기
     * https://programmers.co.kr/learn/courses/30/lessons/12951
     */
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String firstStr = s.charAt(0) + "";
        answer.append(firstStr.toUpperCase());

        for (int i = 1; i < s.length(); i++) {
            String now = s.charAt(i) + "";
            if (now.equals(" ")) {
                answer.append(" ");
            } else if (s.charAt(i - 1) == ' ') {
                answer.append(now.toUpperCase());
            } else {
                answer.append(now.toLowerCase());
            }
        }

        return answer.toString();
    }
}

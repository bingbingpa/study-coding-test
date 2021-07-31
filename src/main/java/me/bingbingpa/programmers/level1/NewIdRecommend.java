package me.bingbingpa.programmers.level1;

public class NewIdRecommend {

    public static void main(String[] args) {
        NewIdRecommend T = new NewIdRecommend();
        System.out.println(T.solution("...!@BaT#*..y.abcdefghijklm"));
    }

    /**
     * 신규 아이디 추천
     * https://programmers.co.kr/learn/courses/30/lessons/72410
     */
    public String solution(String newId) {
        String answer = newId.toLowerCase(); //1
        answer = answer.replaceAll("[^-_.a-z0-9]", ""); //2
        answer = answer.replaceAll("[.]{2,}", "."); //3
        answer = answer.replaceAll("^[.]|[.]$", ""); //4
        answer = answer.length() == 0 ? "a" : answer; //5
        answer = answer.length() > 15 ? answer.substring(0, 15) : answer; //6
        answer = answer.replaceAll("^[.]|[.]$", "");
        answer = appendStr(answer); //7

        return answer;
    }

    private String appendStr(String answer) {
        StringBuilder sb = new StringBuilder(answer);
        if (answer.length() <= 2) {
            while (sb.length() < 3) {
                sb.append(answer.charAt(answer.length() - 1));
            }
            return sb.toString();
        }
        return answer;
    }
}

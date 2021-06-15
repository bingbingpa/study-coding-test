package me.bingbingpa.inflearn.taewon.section1;

import java.util.Scanner;

public class Palindrome {
//    public static void main(String[] args) {
//        Palindrome T = new Palindrome();
//        System.out.println(T.mySolution("gooG"));
//    }

    public static void main(String[] args) {
        Palindrome T = new Palindrome();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution2(str));
    }

    /**
     * TODO 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
     * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
     * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
     */
    public String mySolution(String str) {
        String answer = "YES";
        if (isValid(str)) {
            return "";
        }
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (Character.toUpperCase(str.charAt(lt)) != Character.toUpperCase(str.charAt(rt))) {
                return "NO";
            }
            lt++;
            rt--;
        }

        return answer;
    }

    public String solution1(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) {
            return "YES";
        }
        return answer;
    }

    private boolean isValid(String str) {
        return str.length() == 0;
    }
}

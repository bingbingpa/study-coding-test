package me.bingbingpa.inflearn.taewon._01_string;

import java.util.Scanner;

public class ValidPalindrome {
//    public static void main(String[] args) {
//        ValidPalindrome T = new ValidPalindrome();
//        System.out.println(T.mySolution("found7, time: study; Yduts; emit, 7Dnuof"));
//    }

    public static void main(String[] args) {
        ValidPalindrome T = new ValidPalindrome();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(T.mySolution(str));
    }

    /**
     * TODO 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
     * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
     * 알파벳 이외의 문자들의 무시합니다.
     */
    public String mySolution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(len - i - 1);
            if (Character.isAlphabetic(start) && Character.isAlphabetic(end)) {
                if (start != end) {
                    return "NO";
                }
            }
        }

        return answer;
    }

    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) {
            answer = "YES";
        }

        return answer;
    }
}

package me.bingbingpa.inflearn.taewon._01_string;

import java.util.Scanner;

public class CaseConversion {
//    public static void main(String[] args) {
//        CaseConversion T = new CaseConversion();
//        System.out.println(T.solution("StuDY")); //output: sTUdy
//
//    }

    public static void main(String[] args) {
        CaseConversion t = new CaseConversion();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }

    /**
     * TODO 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     */
    public String solution(String str) {
        if (isValid(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 대문자 아스키 넘버: 65 ~ 90
        // 소문자 아스키 넘버: 97 ~ 120
        // 둘의 차이는 32
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(Character.toUpperCase(ch));
            }
        }

        return sb.toString();
    }

    private boolean isValid(String str) {
        return str.length() == 0 ;
    }
}

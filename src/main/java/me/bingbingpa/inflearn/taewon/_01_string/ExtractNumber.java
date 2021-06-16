package me.bingbingpa.inflearn.taewon._01_string;

import java.util.Scanner;

public class ExtractNumber {
//    public static void main(String[] args) {
//        ExtractNumber T = new ExtractNumber();
//        System.out.println(T.mySolution("g0en2T0s8eSoft"));
//    }

    public static void main(String[] args) {
        ExtractNumber T = new ExtractNumber();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }

    /**
     * TODO 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만들어 리턴하라.
     * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
     * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
     * 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
     */
    public int mySolution(String str) {
        if (isValid(str)) {
            throw new IllegalArgumentException("입력문자열의 길이는 0보다 크고 100보다 작아야 합니다.");
        }
        str = str.replaceAll("[^0-9]", "");

        return Integer.parseInt(str);
    }

    public int solution(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }

        return answer;
    }

    private boolean isValid(String str) {
        return str.length() == 0 || str.length() > 100;
    }
}

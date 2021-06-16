package me.bingbingpa.inflearn.taewon.section1;

import java.util.Scanner;

public class PasswordConversion {
//    public static void main(String[] args) {
//        PasswordConversion T = new PasswordConversion();
//        System.out.println(T.mySolution("#****###**#####**#####**##**"));
//    }

    public static void main(String[] args) {
        PasswordConversion T = new PasswordConversion();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(T.solution(n, str));
    }

    /**
     * TODO 주어진 문자열을 7자리씩 끊어서 #은 1로 *은 0르로 변환하여 바뀐 이진수를 십진수화하고, 아스키 번호를 참고하여 알파벳으로 변경하여 리턴하라.
     */
    public String mySolution(String str) {
        StringBuilder answer = new StringBuilder();
        int len = str.length();
        for (int i = 0; i <= len - 7; i += 7) {
            String result = str.substring(i, i + 7);
            result = result.replace('#', '1');
            result = result.replace('*', '0');
            char num = (char) Integer.parseInt(result, 2);
            answer.append(num);
        }

        return answer.toString();
    }

    public String solution(int n, String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer.append((char) num);

            s = s.substring(7);
        }
        return answer.toString();
    }
}

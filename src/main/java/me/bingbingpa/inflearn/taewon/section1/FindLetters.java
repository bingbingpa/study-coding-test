package me.bingbingpa.inflearn.taewon.section1;

import java.util.Scanner;

public class FindLetters {
//    public static void main(String[] args) {
//        FindLetters T = new FindLetters();
//        System.out.println("result ===== " + T.solution("Computercooler", 'c'));
//    }

    public static void main(String[] args) {
        FindLetters T = new FindLetters();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        System.out.println(T.solution(str, c));
    }

    /**
     * TODO 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
     * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     */
    public int solution(String str, char t) {
        if (isValid(str)) {
            return 0;
        }
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == t) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(String str) {
        return str.length() == 0;
    }
}

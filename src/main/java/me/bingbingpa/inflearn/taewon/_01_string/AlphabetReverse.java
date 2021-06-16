package me.bingbingpa.inflearn.taewon._01_string;

import java.util.Scanner;

public class AlphabetReverse {
//    public static void main(String[] args) {
//        AlphabetReverse T = new AlphabetReverse();
//        System.out.println(T.mySolution("a#b!GE*T@S"));
//    }

    public static void main(String[] args) {
        AlphabetReverse T = new AlphabetReverse();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }

    /**
     * TODO 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     * input: a#b!GE*T@S, output: S#T!EG*b@a
     */
    public String mySolution(String str) {
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        int index = 0;
        while (lt < rt) {
            if (Character.isAlphabetic(str.charAt(index))) {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
            }
            lt++;
            rt--;
            index++;
        }

        return String.valueOf(chars);
    }

    public String solution(String str) {
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(s);
    }
}

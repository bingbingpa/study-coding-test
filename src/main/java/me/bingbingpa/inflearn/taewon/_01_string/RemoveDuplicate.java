package me.bingbingpa.inflearn.taewon._01_string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicate {
//    public static void main(String[] args) {
//        RemoveDuplicate T = new RemoveDuplicate();
//        System.out.println(T.mySolution("ksekkset"));
//    }

    public static void main(String[] args) {
        RemoveDuplicate T = new RemoveDuplicate();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.mySolution(str));
    }


    /**
     * TODO 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
     * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
     * input: ksekkset, output: kset
     */
    public String mySolution(String str) {
        if (isValid(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }

        return sb.toString();
    }

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < length; i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    private boolean isValid(String str) {
        return str.length() == 0;
    }
}

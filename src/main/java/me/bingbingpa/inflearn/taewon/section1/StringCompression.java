package me.bingbingpa.inflearn.taewon.section1;

import java.util.Scanner;

public class StringCompression {
    //    public static void main(String[] args) {
//        StringCompression T = new StringCompression();
//        System.out.println(T.mySolution("KKHSSSSSSSE"));
//        System.out.println(T.mySolution("KSTTTSEEKFKKKDJJGG"));
//    }
    public static void main(String[] args) {
        StringCompression T = new StringCompression();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }

    /**
     * TODO 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     * 단 반복횟수가 1인 경우 생략합니다.
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * 아이디어
     * 1. 압축할 문자열을 저장할 변수(target), 카운트를 저장할 변수(count)를 선언한다.
     * 2. 첫번째 인덱스의 값을 target 에 저장하고, 주어진 문자열을 배열로 만들어 순회한다.
     * 3. target 값과 n번째 인덱스가 같은지 확인하고 같으면 count 값을 증가시키고 아니면 해당 값을 결과값에 저장하고 target 을 n번째 인덱스로 변경한다.
     * 4. 문자열의 끝까지 해당 과정을 반복한다.
     */
    public String mySolution(String str) {
        boolean testExecutable = false;
        if (testExecutable) {
            testIsValid();
        }

        return _mySolution(str);
    }

    private String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s + " ";
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer.append(s.charAt(i));
                answer.append(cnt > 1 ? cnt : "");
                cnt = 1;
            }
        }

        return answer.toString();
    }

    public String _mySolution(String str) {
        if (isValid(str)) {
            throw new IllegalArgumentException("입력 문자열의 길이는 0보다 크고 100을 넘지 않아야 합니다");
        }
        StringBuilder sb = new StringBuilder();
        char[] strArray = str.toCharArray();
        char target = strArray[0];
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (target == str.charAt(i)) {
                count++;
            } else {
                sb.append(target);
                sb.append(count > 1 ? count : "");
                count = 0;
                target = str.charAt(i);
                i--;
            }
        }
        if (target == str.charAt(len - 1)) {
            sb.append(target);
            sb.append(count > 1 ? count : "");
        }

        return sb.toString();
    }

    private boolean isValid(String str) {
        return str.length() == 0 || str.length() > 100;
    }

    private void testIsValid() {
        String str = "tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";
        System.out.println("expected: true,  result: " + isValid(str) + " input: " + str);
        System.out.println("expected: true,  result: " + isValid("") + " input: " + "");
        System.out.println("expected: false, result: " + isValid("test") + " input: " + "test");
    }
}

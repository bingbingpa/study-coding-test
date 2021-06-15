package me.bingbingpa.inflearn.taewon.section1;

import java.util.Scanner;

public class WordInSentence {
//        public static void main(String[] args) {
//        WordInSentence t = new WordInSentence();
//        System.out.println(t.solution1("it is time to study"));
//    }
    public static void main(String[] args) {
        WordInSentence t = new WordInSentence();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.solution2(str));
    }

    /**
     * TODO 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
     * 문장속의 각 단어는 공백으로 구분됩니다.
     * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
     * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
     * input: it is time to study, output: study
     *
     * TDD
     * 입력 문자열은 공백 또는 null 이 될 수 없다.
     * 공백을 기준으로 문자열의 길이를 체크한다.
     * 공백을 기준으로 처음과 다음 문자열의 길이를 비교하여 더 큰 값을 변수에 담는다. 값이 같다면 패스
     * 문장을 모두 확인 후에 변수에 담긴 값을 리턴한다.
     */
    public String mySolution(String str) {
        if (isValid(str)) {
            return null;
        }
        String result = "";

        int length = str.length();
        int start = 0;
        for (int i = 0; i < length; i++) {
            char target = str.charAt(i);
            if (target == ' ') {
                String temp = str.substring(start, i);
                start = i + 1;
                result = getMaxWord(result, temp);
            }
            if (i == length - 1) {
                String temp = str.substring(start);
                result = getMaxWord(result, temp);
            }
        }
        return result;
    }

    public String solution1(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }

    private String getMaxWord(String result, String temp) {
        if (temp.length() > result.length()) {
            result = temp;
        }
        return result;
    }

    private boolean isValid(String str) {
        return str.length() == 0;
    }
}

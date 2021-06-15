package me.bingbingpa.inflearn.taewon.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordReverse {

//    public static void main(String[] args) {
//        WordReverse T = new WordReverse();
//        System.out.println(T.solution2(new String[]{"good", "Time", "Big"}));
//    }

    public static void main(String[] args) {
        WordReverse T = new WordReverse();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }
        for (String x : T.solution2(str)) {
            System.out.println(x);
        }
    }

    /**
     * TODO N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
     * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
     * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
     */
    public void mySolution(String[] str) {
        for (String x : str) {
            String temp = new StringBuilder(x).reverse().toString();
            System.out.println(temp);
        }
    }

    public List<String> solution1(String[] str) {
        List<String> answer = new ArrayList<>();
        for (String x : str) {
            answer.add(new StringBuilder(x).reverse().toString());
        }
        return answer;
    }

    public List<String> solution2(String[] str) {
        List<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(s));
        }
        return answer;
    }
}

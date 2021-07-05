package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class IronStick {
//    public static void main(String[] args) {
//        IronStick T = new IronStick();
//        System.out.println(T.solution("(((()(()()))(())()))(()())"));
//    }

    public static void main(String[] args) {
        IronStick T = new IronStick();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }

    /**
     * TODO 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
     */
    public int solution(String str) {
        int answer = 0;
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                deque.push('(');
            } else {
                deque.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += deque.size();
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}

package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Postfix {
//    public static void main(String[] args) {
//        Postfix T = new Postfix();
//        System.out.println(T.mySolution("352+*9-"));
//    }

    public static void main(String[] args) {
        Postfix T = new Postfix();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.mySolution(str));
    }

    /**
     * TODO 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     */
    public int mySolution(String str) {
        Deque<Integer> deque = new LinkedList<>();

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                deque.push(ch - '0');
            } else {
                deque.push(calculate(deque.pop(), deque.pop(), ch));
            }
        }

        return deque.pop();
    }

    private int calculate(Integer num1, Integer num2, char ch) {
        switch (ch) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return 0;
        }
    }
}

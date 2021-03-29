package me.bingbingpa.inflearn.interview._03_stack;

import java.util.LinkedList;

public class EvaluationPostfix {
    public static void main(String[] args) {
        EvaluationPostfix postfix = new EvaluationPostfix();
        System.out.println(postfix.evaluate("52+") == 7);
        System.out.println(postfix.evaluate("52-") == 3);
        System.out.println(postfix.evaluate("52*") == 10);
        System.out.println(postfix.evaluate("52/") == 2);
        System.out.println(postfix.evaluate("521+-9*") == 18);
    }

    /**
     * TODO 포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.
     * 예) 12+      => 3
     * 예) 123+-5*  => -20
     */
    private int evaluate(String postfix) {
        postfix = postfix.trim();
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                numbers.push(c - '0');
            } else {
                int right = numbers.pop();
                int left = numbers.pop();

                switch (c) {
                    case '+':
                        numbers.push(left + right);
                        break;
                    case '-':
                        numbers.push(left - right);
                        break;
                    case '*':
                        numbers.push(left * right);
                        break;
                    case '/':
                        numbers.push(left / right);
                        break;
                }
            }
        }
        return numbers.pop();
    }
}

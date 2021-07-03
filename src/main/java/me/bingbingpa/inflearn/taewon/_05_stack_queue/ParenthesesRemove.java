package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesesRemove {
//    public static void main(String[] args) {
//        ParenthesesRemove T = new ParenthesesRemove();
//        System.out.println(T.mySolution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
//    }

    public static void main(String[] args) {
        ParenthesesRemove T = new ParenthesesRemove();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }

    /**
     * TODO 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
     */
    public String mySolution(String str) {
        StringBuilder answer = new StringBuilder();
        char[] chars = str.toCharArray();
        Deque<Character> deque = new LinkedList<>();

        for (char ch : chars) {
            if (ch == '(') {
                deque.push(ch);
            } else {
                if (deque.isEmpty() && ch != ')') {
                    answer.append(ch);
                }
                if (!deque.isEmpty() && ch == ')') {
                    deque.pop();
                }
            }
        }
        return answer.toString();
    }

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
        for (Character ch : stack) {
            answer.append(ch);
        }
        return answer.toString();
    }
}

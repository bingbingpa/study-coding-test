package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CorrectParenthesis {

//    public static void main(String[] args) {
//        CorrectParenthesis T = new CorrectParenthesis();
//        System.out.println(T.mySolution("(()(()))(()"));
//    }

    public static void main(String[] args) {
        CorrectParenthesis T = new CorrectParenthesis();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.mySolution(str));
    }

    /**
     * TODO 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력하라.
     */
    public String mySolution(String str) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}

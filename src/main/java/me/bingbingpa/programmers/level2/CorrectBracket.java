package me.bingbingpa.programmers.level2;

import java.util.*;

public class CorrectBracket {

    public static void main(String[] args) {
        CorrectBracket T = new CorrectBracket();
        System.out.println(T.solution("()()"));
    }

    /**
     * 올바른 괄호
     * https://programmers.co.kr/learn/courses/30/lessons/12909
     */
    boolean solution(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

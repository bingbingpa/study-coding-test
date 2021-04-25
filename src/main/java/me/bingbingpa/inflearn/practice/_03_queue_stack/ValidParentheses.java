package me.bingbingpa.inflearn.practice._03_queue_stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("result ================ " + validParentheses.solution1("{[]}"));
        System.out.println("result ================ " + validParentheses.solution2("()[]{}"));
        System.out.println("result ================ " + validParentheses.solution1("([)]"));
        System.out.println("result ================ " + validParentheses.solution2("(]"));
    }

    /**
     * TODO 주어진 수식의 괄호짝이 맞는지 확인하는 코드를 작성하라.
     * 예) input: "{[]}", output: true, input: "()[]{}", output: true
     * input: "([)]" , output: false, input"(]", output: false
     */
    public boolean solution1(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        List<Character> openingBrackets = Arrays.asList('(', '{', '[');
        List<Character> closingBrackets = Arrays.asList(')', '}', ']');

        for (char ch : chars) {
            if (openingBrackets.contains(ch)) {
                stack.push(ch);
            } else if (closingBrackets.contains(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }

                Character openingBracket = stack.pop();
                if (closingBrackets.indexOf(ch) != openingBrackets.indexOf(openingBracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean solution2(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(str.charAt(i));
                    break;
            }
        }
        return stack.isEmpty();
    }
}

package me.bingbingpa.inflearn.interview._03_stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CheckingBrackets {
    public static void main(String[] args) {
        CheckingBrackets checkingBrackets = new CheckingBrackets();
        System.out.println(checkingBrackets.check("[{1 + 2 * (2 + 2)} - (1 - 3)]"));
        System.out.println(checkingBrackets.check("[{1 + 2 * (2 + 2)} - [1 - 3)]"));
        System.out.println(checkingBrackets.check("((())"));
        System.out.println(checkingBrackets.check("(()))"));
        System.out.println(checkingBrackets.check("{{()}}"));
    }

    /**
     * TODO 주어진 수식의 괄호짝이 맞는지 확인하는 코드를 작성하라.
     * 예) [{1 + 2 * (2 + 2)} - (1 - 3)]   => true
     * 예) [{1 + 2 * (2 + 2)} - [1 - 3)]   => false
     */
    private boolean check(String mathExpression) {
//        시간 복잡도: O(N)
//        공간 복잡도: O(N)
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();
        List<Character> openingBrackets = Arrays.asList('(', '{', '[');
        List<Character> closingBrackets = Arrays.asList(')', '}', ']');

        for (char c : chars) {
            if (openingBrackets.contains(c)) {
                brackets.push(c);
            } else if (closingBrackets.contains(c)) {
                if (brackets.isEmpty()) {
                    return false;
                }

                Character openingBracket = brackets.pop();
                if (closingBrackets.indexOf(c) != openingBrackets.indexOf(openingBracket)) {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}

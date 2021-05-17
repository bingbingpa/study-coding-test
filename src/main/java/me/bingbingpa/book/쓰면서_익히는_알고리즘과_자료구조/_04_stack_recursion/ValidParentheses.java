package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._04_stack_recursion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("result ============ " + solution1("(")); // false
        System.out.println("result ============ " + solution1("]")); // false
        System.out.println("result ============ " + solution1("((){})")); // true
        System.out.println(solution2("[{1 + 2 * (2 + 2)} - (1 - 3)]")); // true
        System.out.println(solution2("[{1 + 2 * (2 + 2)} - [1 - 3)]")); // false
        System.out.println(solution2("((())")); // false
        System.out.println(solution2("(()))")); // false
        System.out.println(solution2("{{()}}")); // true
    }

    /**
     * TODO 주어진 문자열의 괄호 쌍이 맞는지 판별하라.
     */
    public static boolean solution1(String str) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N)
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parentMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (char ch : chars) {
            if (!parentMap.containsKey(ch)) {
                stack.push(ch);
            } else {
                Character pair = !stack.isEmpty() ? stack.pop() : ' ';
                if (parentMap.get(ch) != pair) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean solution2(String str) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N)
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
                if (openingBrackets.indexOf(openingBracket) != closingBrackets.indexOf(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

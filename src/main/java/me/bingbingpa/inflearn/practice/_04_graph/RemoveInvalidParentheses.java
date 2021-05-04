package me.bingbingpa.inflearn.practice._04_graph;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        RemoveInvalidParentheses result = new RemoveInvalidParentheses();
//        String s = "(a)())()"; // output: ["(a)()()", "(a())()"]
        String s = "()())()"; // output: ["()()()", "(())()"]
//        String s = ")("; // output: [""]
        System.out.println("result ================= " + result.solution(s));
//        result.testGetSubstring();
//        result.testIsValidParentheses();
//        result.testIsAplpha();
    }

    /**
     * TODO 최소 수의 유효하지 않은 괄호를 제거하여 입력 문자열의 괄호가 유효한 모든 결과를 리턴하라.
     * TEST
     * - 주어진 문자가 알파벳인지 판단한다.
     * - 인덱스에 해당하는 문자를 제외한 문자열을 리턴한다.
     * - 리턴한 문자열을 스택에 저장 후 쌍이 맞는지 체크
     * - 쌍이 맞다면 리스트에 추가
     */
    public List<String> solution(String str) {
        if (isValidArgument(str)) {
            throw new IllegalArgumentException("입력 문자열은 최소한 1자리 이상이어야 합니다.");
        }

        List<String> result = new ArrayList<>();
        int length = str.length();
        for (int index = 0; index < length; index++) {
//            if (isAlpha(str.charAt(index))) {
//                continue;
//            }
            String subStr = getSubstring(str, index);
            if (isValidParentheses(subStr) && !result.contains(subStr)) {
                result.add(subStr);
            }
        }

        return result;
    }

    private List<String> solution2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    res.add(str);
                    found = true;
                }
                if(found) {
                    continue;
                }
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') {
                        continue;
                    }
                    String newStr = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if(count < 0) {
                    return false;
                }
            }
        }
        return count ==0;
    }

    private boolean isValidArgument(String str) {
        return "".equals(str) || str.trim().length() == 0 ;
    }

    private boolean isAlpha(char ch) {
//        65부터 122 가 알파벳 아스키 코드
        return ch >= 65 && ch <= 122;
    }

    private String getSubstring(String str, int index) {
        return str.substring(0, index) + str.substring(index+1);
    }

    private boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        List<Character> openingBrackets = Arrays.asList('(', '{', '[');
        List<Character> closingBrackets = Arrays.asList(')', '}', ']');
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (openingBrackets.contains(ch)) {
                stack.push(ch);
            } else if (closingBrackets.contains(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }

                Character openBracket = stack.pop();
                if (closingBrackets.indexOf(ch) != openingBrackets.indexOf(openBracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private void testIsAplpha() {
        System.out.println("a ========== " + isAlpha('a'));
        System.out.println("C ========== " + isAlpha('C'));
    }

    private void testGetSubstring() {
        String str = "(a)())()";
        System.out.println("substring 2 ======= " + "(a())()".equals(getSubstring(str, 2)));
        System.out.println("substring 5 ======= " + "(a)()()".equals(getSubstring(str, 5)));
    }

    private void testIsValidParentheses() {
        System.out.println("(a)()() ================ " + isValidParentheses("(a)()()"));
        System.out.println("(a)())() ================ " + !isValidParentheses("(a)())()"));
        System.out.println(")( ================ " + !isValidParentheses(")("));
        System.out.println("( ================ " + !isValidParentheses("("));
    }
}

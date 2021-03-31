package me.bingbingpa.inflearn.basic._01_string;

public class ToCharArray {
    /**
     * ===================Problem===================
     * Input: String s = "in(f(lea)r)n)";
     * Output: “in(f(lea)r)n”
     * Input: String s = “(a(b(c)d)";
     * Output: “(a(bc)d)”
     * ===================Note===================
     * 최소 괄호의 수를 제거하여 '(' ')' 처럼 유효한 parentheses string 를 리턴한다
     * 1. 빈 문자열이거나 소문자 만 포함
     * 2. (ab), ab(c)d
     * ===================문제 Format===================
     * class Solution {
     * public String solve(String str) {
     * }
     * }
     */

    public static void main(String[] args) {
        String s = "(a(b(c)d)";
//		String s = "(((a(b(c(e(f)d))";
//	    String  s = "in(f(lea)r)n)";
//		String  s = "a)b(c)d";
//        String  s = "a)b(c)d)";
//		String  s = "(()))";
//		String  s = "(()";
//	    String  s = "))((";
        System.out.println("result ================= " + solve(s));
    }

    public static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int openBrace = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openBrace++;
            } else if (c == ')') {
                if(openBrace == 0 ) continue;
                openBrace--;
            }
            sb.append(c);
        }

        for (int i = sb.length() - 1; i >= 0; i--) {
            if(sb.charAt(i) == '(' && openBrace-- >0) continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}

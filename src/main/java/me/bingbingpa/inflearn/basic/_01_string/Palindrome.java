package me.bingbingpa.inflearn.basic._01_string;

public class Palindrome {
    private int start;
    private int end;

    /**
     * ===================Problem===================
     * Input: s = "bananas"
     * Output: "anana"
     * Input: s = "babad"
     * Output: "bab”
     * return the longest palindromic substring in s
     * ===================문제 Format===================
     * class Solution {
     * public String solve(String s) {
     * }
     * }
     */
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String s = "bananas";
        System.out.println("result ================== " + palindrome.solve(s));

    }

    public String solve(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        for (int i = 0; i < length - 1; i++) {
            findSubstring(s, i, i);
            findSubstring(s, i, i + 1);
        }
        return s.substring(start, start + end);
    }

    public void findSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (end < right - left - 1) {
            start = left + 1;
            end = right - left - 1;
        }
    }
}

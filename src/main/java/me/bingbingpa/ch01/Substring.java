package me.bingbingpa.ch01;

public class Substring {
    /**
     * ===================Problem===================
     * Input: String str[] = { “test”, “teacher" }
     * Output: “te”
     * 앞자리 te를 리턴한다
     * ===================문제 Format===================
     * class Solution {
     *     public String solve(String[] strs) {
     *     }
     * }
     */
    public static void main(String[] args) {
        String[] str = {"test", "teacher"};
        System.out.println("result =============== " + solve(str));
    }

    public static String solve(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];

        int length = strs.length;
        for (int i = 1; i < length; i++) {
            while (strs[i].indexOf(firstStr) != 0) {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
            }
        }

        return firstStr;
    }
}

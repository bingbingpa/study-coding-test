package me.bingbingpa.ch01;

public class CharAt {
    /**
     * ===================Problem===================
     * Input: 1->2->3,
     *         8->8->8
     * Output: 1011
     * 문자열처럼 생긴 음이 아닌 정수값 num1, num2(non-negative integers num1 and num2 represented as string)
     * 문자열로 num1, num2 의 합을 return
     * ===================Note===================
     * 1) num1및 둘 다의 길이 num2는 <1000입니다.
     * 2) 둘 다 num1및 num2숫자 만 포함합니다 0-9.
     * 3) num1및 둘 다 num2선행 0을 포함하지 않습니다
     * ===================문제 Format===================
     * class Solution {
     *     public String solve(String num1, String num2) {
     *     }
     * }
     */
    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "888";
        System.out.println("result ========= "+ solve(nums1, nums2));
    }

    public static String solve(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;

        while (num1Length >= 0 || num2Length >= 0) {
            int n1 = 0;
            int n2 = 0;
            if (num1Length >= 0) {
                n1 = num1.charAt(num1Length) - '0';
            }
            if (num2Length >= 0) {
                n2 = num2.charAt(num2Length) - '0';
            }

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);

            num1Length--;
            num2Length--;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}

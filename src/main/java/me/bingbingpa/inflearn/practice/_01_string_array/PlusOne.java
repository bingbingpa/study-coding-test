package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println("result ============ " + Arrays.toString(plusOne.solution(new int[]{9, 9, 9})));
    }

    /**
     * TODO 주어진 배열에 1을 더한 값의 배열을 리턴하라.
     * 예) input: [1,2,3], output: [1,2,4]
     * input: [9,9,9], output: [1,0,0,0]
     */
    public int[] solution(int[] digits) {
        int index = digits.length - 1; //2
        int carry = 1;

        while (index >= 0 && carry > 0) {
            digits[index] = (digits[index] + 1) % 10;
            if (digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            index--;
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}

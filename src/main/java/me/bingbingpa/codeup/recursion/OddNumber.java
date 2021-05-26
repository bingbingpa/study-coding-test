package me.bingbingpa.codeup.recursion;

public class OddNumber {
    public static void main(String[] args) {
        solution(2, 7); // output: 3 5 7
    }

    /**
     * TODO 두수 사이의 홀수를 재귀를 사용해서 출력하라.
     * 두 수 a, b 가 입력된다. (1<=a<=b<=100)
     */
    public static void solution(int start, int end) {
        if (start > end) {
            return;
        }
        if (start % 2 == 1) {
            System.out.printf(start + " ");
        }
        solution(start+1, end);
    }
}

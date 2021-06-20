package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int x : T.solution1(n)) {
            System.out.printf(x + " ");
        }
    }

    /**
     * TODO 피보나치 수열을 출력한다.
     * 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
     * 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
     */
    public int[] solution1(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    public void solution2(int n) {
        int a = 1;
        int b = 1;
        int c;
        System.out.printf(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a+b;
            System.out.printf(c + " ");
            a = b;
            b = c;
        }
    }
}

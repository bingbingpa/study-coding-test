package me.bingbingpa.inflearn.taewon._03_twopointers;

import java.util.Scanner;

public class NaturalNumber {
//    public static void main(String[] args) {
//        NaturalNumber T = new NaturalNumber();
//        System.out.println(T.mySolution(15));
//    }

    public static void main(String[] args) {
        NaturalNumber T = new NaturalNumber();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.mySolution(n));
    }

    /**
     * TODO 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
     */
    public int mySolution(int num) {
        boolean testExecutable = false;

        if (testExecutable) {
            testIsValid();
        }

        return _mySolution(num);
    }

    private int _mySolution(int num) {
        if (!isValid(num)) {
            throw new IllegalArgumentException("입력값은 7보다 크거나 같고 1000보다 작거나 같아야 합니다.");
        }
        int answer = 0;
        int length = num / 2 + 1;
        int[] arr = new int[length];
        int lt = 0;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < length; rt++) {
            sum += arr[rt];
            if (sum == num) {
                answer++;
            }
            while (sum >= num) {
                sum -= arr[lt++];
                if (sum == num) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isValid(int num) {
        return num >= 7 && num <= 1000;
    }

    private void testIsValid() {
        String testMethod = "isValid";
        assertThat(testMethod, "0" , !isValid(0));
        assertThat(testMethod, "7" , isValid(7));
        assertThat(testMethod, "33" , isValid(33));
        assertThat(testMethod, "1000" , isValid(1000));
        assertThat(testMethod, "1001" , !isValid(1001));
    }

    private void assertThat(String testMethod, String input, boolean result) {
        String testMessage = "testMethod: " + testMethod + ", input: " + input;
        if (result) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}

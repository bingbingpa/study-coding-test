package me.bingbingpa.inflearn.taewon._03_twopointers;

import java.util.Scanner;

public class Subsequence {

//    public static void main(String[] args) {
//        Subsequence T = new Subsequence();
//        int n = 6;
//        int[] arr = new int[]{1, 2, 1, 3, 1, 1, 1, 2};
//        System.out.println(T.solution(n , arr));
//    }

    public static void main(String[] args) {
        Subsequence T = new Subsequence();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.mySolution(n, arr));
    }

    /**
     * TODO 연속 부분 수열의 합이 되는 경우의 수를 리턴하라.
     * 내가 푼건 시간초과;;;
     */
    public int mySolution(int n, int[] arr) {
        boolean testExecutable = false;
        if (testExecutable) {
            testIsValidSum();
            testIsValidSequence();
        }

        return _mySolution(n, arr);
    }

    public int solution(int n, int[] arr) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        int length = arr.length;
        for (int rt = 0; rt < length; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }


        return answer;
    }

    private int _mySolution(int n, int[] arr) {
        checkArgument(n, arr);
        int answer = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int p1 = i;
            int sum = 0;
            while (p1 < length) {
                sum += arr[p1++];
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    private void checkArgument(int n, int[] arr) {
        if (!isValidSequence(arr)) {
            throw new IllegalArgumentException("입력하는 수열의 길이는 1보다 크거나 같고, 100,000 보다 작거나 같아야 합니다.");
        }
        if (!isValidSum(n)) {
            throw new IllegalArgumentException("입력하는 수열의 합은 1보다 크거나 같고, 100,000,000 보다 작거나 같아야 합니다.");
        }
    }

    private boolean isValidSum(int n) {
        return n >= 1 && n <= 100000000;
    }

    private boolean isValidSequence(int[] arr) {
        return arr.length >= 1 && arr.length <= 100000;
    }

    private void testIsValidSum() {
        String methodName = "testIsValidSum";
        assertThat(methodName, "1", isValidSum(1));
        assertThat(methodName, "0", !isValidSum(0));
        assertThat(methodName, "100", isValidSum(100));
        assertThat(methodName, "100,000,000", isValidSum(100000000));
        assertThat(methodName, "100,000,333", !isValidSum(100000333));
    }

    private void testIsValidSequence() {
        String methodName = "isValidSequence";
        assertThat(methodName, "arr[0]", !isValidSequence(new int[]{}));
        assertThat(methodName, "arr[1]", isValidSequence(new int[1]));
        assertThat(methodName, "arr[20]", isValidSequence(new int[20]));
        assertThat(methodName, "arr[100000]", isValidSequence(new int[100000]));
        assertThat(methodName, "arr[200000]", !isValidSequence(new int[200000]));
    }

    private void assertThat(String methodName, String input, boolean result) {
        String testMessage = "methodName: " + methodName + ", input: " + input;
        if (result) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}

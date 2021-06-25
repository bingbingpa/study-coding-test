package me.bingbingpa.inflearn.taewon._03_twopointers;

import java.util.Scanner;

public class MaxSales {
//    public static void main(String[] args) {
//        MaxSales T = new MaxSales();
//        int[] arr = new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
//        int n = 3;
//        System.out.println(T.mySolution(n, arr));
//    }

    public static void main(String[] args) {
        MaxSales T = new MaxSales();
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int n = scanner.nextInt();
        int arr[] = new int[day];
        for (int i = 0; i < day; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.mySolution(n, arr));
    }

    /**
     * TODO N일 동안의 매출기록에서  연속된 K일 동안의 최대 매출액이 얼마인지 구하라.
     * N(5<=N<=100,000)과 K(2<=K<=N)
     */
    public int mySolution(int n, int[] arr) {
        boolean testExecutable = false;
        if (testExecutable) {
            testIsValidSalesRecord();
            testIsValidMaxSalesDay();
        }

        return _mySolution(n, arr);
    }

    public int _mySolution(int n, int[] arr) {
        checkArgument(n, arr);
        int answer = 0;
        int length = arr.length - n;
        for (int i = 0; i < length; i++) {
            int count = 0;
            int sum = 0;
            while (count < n) {
                sum += arr[i + count++];
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public int solution(int n, int[] arr) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int answer = sum;

        int length = arr.length;
        for (int i = n; i < length; i++) {
            sum += (arr[i] - arr[i - n]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    private void checkArgument(int n, int[] arr) {
        if (!isValidSalesRecord(arr)) {
            throw new IllegalArgumentException("매출 기록일수는 5일보다 크거나 같고 100000일 보다 작거나 같아야 합니다.");
        }
        if (!isValidMaxSalesDay(n, arr)) {
            throw new IllegalArgumentException("최대 매출기록 일수는 2일보다 크거나 같고 매출 기록일수보다 작거나 같아야 합니다.");
        }
    }

    private boolean isValidMaxSalesDay(int n, int[] arr) {
        return n >= 2 && n <= arr.length;
    }

    private boolean isValidSalesRecord(int[] arr) {
        return arr.length >= 5 && arr.length <= 100000;
    }

    private void testIsValidMaxSalesDay() {
        String testMethod = "testIsValidMaxSalesDay";
        assertThat(testMethod, "2, arr[10]", isValidMaxSalesDay(2, new int[10]));
        assertThat(testMethod, "15, arr[10]", !isValidMaxSalesDay(15, new int[10]));
    }

    private void testIsValidSalesRecord() {
        String testMethod = "testIsValidSalesRecord";
        assertThat(testMethod, "0", !isValidSalesRecord(new int[]{}));
        assertThat(testMethod, "2", !isValidSalesRecord(new int[2]));
        assertThat(testMethod, "5", isValidSalesRecord(new int[5]));
        assertThat(testMethod, "100000", isValidSalesRecord(new int[100000]));
        assertThat(testMethod, "100001", !isValidSalesRecord(new int[100001]));
        assertThat(testMethod, "30", isValidSalesRecord(new int[30]));
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

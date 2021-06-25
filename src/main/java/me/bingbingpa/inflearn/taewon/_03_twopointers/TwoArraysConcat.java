package me.bingbingpa.inflearn.taewon._03_twopointers;

import java.util.*;

public class TwoArraysConcat {
//    public static void main(String[] args) {
//        TwoArraysConcat T = new TwoArraysConcat();
//        int[] arr1 = new int[]{1, 3, 5};
//        int[] arr2 = new int[]{2, 3, 6, 7, 9};
//        List<Integer> result = T.mySolution(arr1, arr2);
//        for (Integer num : result) {
//            System.out.printf(num +" ");
//        }
//    }

    public static void main(String[] args) {
        TwoArraysConcat T = new TwoArraysConcat();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        List<Integer> result = T.solution(arr1, arr2);
        for (Integer num : result) {
            System.out.printf(num + " ");
        }

    }

    /**
     * TODO 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     * 배열의 크기는 (1<=N<=100)
     */
    public List<Integer> mySolution(int[] arr1, int[] arr2) {
        boolean testExecutable = false;
        if (testExecutable) {
            testIsValid();
        }

        return _mySolution(arr1, arr2);
    }

    public List<Integer> _mySolution(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        if (!isValid(arr1, arr2)) {
            throw new IllegalArgumentException("배열의 크기는 1보다 크거나 같고 100보다 크거가 작아야 합니다.");
        }
        for (int num : arr1) {
            answer.add(num);
        }

        for (int num : arr2) {
            answer.add(num);
        }

        Collections.sort(answer);

        return answer;
    }

    public List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }
        while (p1 < n) {
            answer.add(arr1[p1++]);
        }

        while (p2 < m) {
            answer.add(arr2[p2++]);
        }

        return answer;
    }

    private boolean isValid(int[] arr1, int[] arr2) {
        return arr1.length >= 1 && arr1.length <= 100 && arr2.length >= 1 && arr2.length <= 100;
    }

    private void testIsValid() {
        String testName = "testIsValid";
        assertThat(testName, "0", !isValid(new int[]{}, new int[]{}));
        assertThat(testName, "101", !isValid(new int[101], new int[101]));
        assertThat(testName, "20", isValid(new int[20], new int[20]));
    }

    private void assertThat(String testName, String input, boolean result) {
        String testMessage = "testName: " + testName + ", input: " + input;
        if (result) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}

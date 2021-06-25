package me.bingbingpa.inflearn.taewon._03_twopointers;

import java.util.*;

public class TwoArrayDuplicateNumber {
//    public static void main(String[] args) {
//        TwoArrayDuplicateNumber T = new TwoArrayDuplicateNumber();
//        List<Integer> result = T.mySolution(new int[]{1, 3, 9, 5, 2}, new int[]{3, 2, 5, 7, 8});
//        for (Integer num : result) {
//            System.out.printf(num + " ");
//        }
//    }

    public static void main(String[] args) {
        TwoArrayDuplicateNumber T = new TwoArrayDuplicateNumber();
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
        List<Integer> result = T.mySolution(arr1, arr2);
        for (Integer num : result) {
            System.out.printf(num + " ");
        }
    }


    /**
     * TODO A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
     * 배열의 크기는 (1<=N<=30,000)
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
            throw new IllegalArgumentException("배열의 크기는 1보다 크거나 같고 30000 작거나 같아야 합니다.");
        }
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (set.contains(num)) {
                answer.add(num);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

    private boolean isValid(int[] arr1, int[] arr2) {
        return arr1.length >= 1 && arr1.length <= 30000 && arr2.length >= 1 && arr2.length <= 30000;
    }

    private void testIsValid() {
        String testMethod = "testIsValid";
        assertThat(testMethod, "0", !isValid(new int[]{}, new int[]{}));
        assertThat(testMethod, "30000", isValid(new int[30000], new int[30000]));
        assertThat(testMethod, "30001", !isValid(new int[30001], new int[30001]));
        assertThat(testMethod, "30", isValid(new int[30], new int[30]));

    }

    private void assertThat(String testName, String input, boolean result) {
        String testMessage = "testMethod: " + testName + ", input: " + input;
        if (result) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}

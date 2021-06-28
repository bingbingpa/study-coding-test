package me.bingbingpa.inflearn.taewon._03_twopointers;

import java.util.Scanner;

public class MaxSubSequence {

    //    public static void main(String[] args) {
//        MaxSubSequence T = new MaxSubSequence();
//        int n = 2;
//        int[] arr = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
//        System.out.println(T.solution(arr, n));
//    }

    public static void main(String[] args) {
        MaxSubSequence T = new MaxSubSequence();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(arr, k));
    }

    /**
     * TODO 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
     * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     */
    private int solution(int[] arr, int n) {
        checkArgument(arr, n);
        int answer = 0;
        int length = arr.length;
        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt < length; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > n) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    private void checkArgument(int[] arr, int n) {
        if (!isValidArray(arr)) {
            throw new IllegalArgumentException("입력 값의 길이는 5보다 크거나 같고 100000보다 작거나 같아야 합니다.");
        }
        if (!isValidChangeNumber(arr, n)) {
            throw new IllegalArgumentException("변경할 수는 입력한 배열의 길이보다 클 수 없습니다.");
        }
    }

    private boolean isValidChangeNumber(int[] arr, int n) {
        return n < arr.length;
    }

    private boolean isValidArray(int[] arr) {
        return arr.length >= 5 && arr.length <= 100000;
    }
}

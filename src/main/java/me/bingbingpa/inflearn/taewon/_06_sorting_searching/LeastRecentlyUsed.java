package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Scanner;

public class LeastRecentlyUsed {

//    public static void main(String[] args) {
//        LeastRecentlyUsed T = new LeastRecentlyUsed();
//        int[] result = T.mySolution(5, new int[]{1, 2, 3, 2, 6, 2, 3, 5, 7});
//        for (int i : result) {
//            System.out.printf(i + " ");
//        }
//    }

    public static void main(String[] args) {
        LeastRecentlyUsed T = new LeastRecentlyUsed();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] result = T.mySolution(size, arr);
        for (int i : result) {
            System.out.printf(i + " ");
        }
    }

    /**
     * TODO 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
     */
    public int[] mySolution(int size, int[] arr) {
        int[] result = new int[size];
        for (int i : arr) {
            int index = getIndex(result, i);
            sort(result, index);
            result[0] = i;
        }

        return result;
    }

    public int[] solution(int size, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        return cache;
    }

    private void sort(int[] arr, int index) {
        for (; index >= 1; index--) {
            arr[index] = arr[index - 1];
        }
    }

    private int getIndex(int[] arr, int num) {
        int target = arr.length - 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                target = i;
                break;
            }
        }
        return target;
    }
}

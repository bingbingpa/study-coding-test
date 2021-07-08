package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Scanner;

public class BubbleSort {

//    public static void main(String[] args) {
//        BubbleSort T = new BubbleSort();
//        int[] result = T.mySolution(new int[]{13, 5, 11, 7, 23, 15});
//        for (int i : result) {
//            System.out.printf(i + " ");
//        }
//    }

    public static void main(String[] args) {
        BubbleSort T = new BubbleSort();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] result = T.mySolution(arr);
        for (int i : result) {
            System.out.printf(i + " ");
        }
    }

    /**
     * TODO 오름차순으로 정렬된 수열을 출력하시오.
     */
    public int[] mySolution(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}

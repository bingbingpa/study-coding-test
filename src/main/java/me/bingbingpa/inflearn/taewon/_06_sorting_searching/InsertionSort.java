package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort T = new InsertionSort();
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
     * TODO 삽입정렬을 이용해서 오름차순으로 정렬하기
     */
    public int[] mySolution(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}

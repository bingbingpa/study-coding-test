package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Scanner;

public class SelectionSort {

//    public static void main(String[] args) {
//        SelectionSort T = new SelectionSort();
//        int[] ints = T.mySolution(new int[]{13, 5, 11, 7, 23, 15});
//        for (int i : ints) {
//            System.out.printf(i + " ");
//        }
//    }

    public static void main(String[] args) {
        SelectionSort T = new SelectionSort();
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
     * TODO N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     */
    public int[] mySolution(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

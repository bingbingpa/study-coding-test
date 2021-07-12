package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

//    public static void main(String[] args) {
//        BinarySearch T = new BinarySearch();
//        System.out.println(T.mySolution(new int[]{23, 87, 65, 12, 57, 32, 99, 81}, 32));
//    }

    public static void main(String[] args) {
        BinarySearch T = new BinarySearch();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.mySolution(arr, target));
    }

    /**
     * TODO 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
     */
    public int mySolution(int[] arr, int target) {
        int answer = 0;
        int n = arr.length;
        Arrays.sort(arr);
        int lt = 0 ;
        int rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == target) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > mid) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
}

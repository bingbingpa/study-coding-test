package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {

//    public static void main(String[] args) {
//        MusicVideo T = new MusicVideo();
//        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
//    }

    public static void main(String[] args) {
        MusicVideo T = new MusicVideo();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(arr, m));
    }

    /**
     * TODO DVD 의 최소 용량 크기를 출력하세요.(결정알고리즘)
     */
    public int solution(int[] arr, int target) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= target) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}

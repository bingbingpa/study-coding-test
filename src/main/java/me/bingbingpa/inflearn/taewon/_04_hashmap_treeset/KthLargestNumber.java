package me.bingbingpa.inflearn.taewon._04_hashmap_treeset;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class KthLargestNumber {

//    public static void main(String[] args) {
//        KthLargestNumber T = new KthLargestNumber();
//        System.out.println(T.solution(new int[]{13, 15, 34, 23, 45, 65, 33, 11, 26, 42}, 3));
//    }

    public static void main(String[] args) {
        KthLargestNumber T = new KthLargestNumber();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(arr, n, k));
    }

    /**
     * TODO k 번째 큰 수를 구하라.
     */
    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        Set<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : Tset) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }

        return answer;
    }
}

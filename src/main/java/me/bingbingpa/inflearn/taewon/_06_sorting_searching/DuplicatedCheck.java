package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicatedCheck {

//    public static void main(String[] args) {
//        DuplicatedCheck T = new DuplicatedCheck();
//        System.out.println(T.mySolution(new int[]{20, 25, 52, 30, 39, 33, 43, 33}));
//    }

    public static void main(String[] args) {
        DuplicatedCheck T = new DuplicatedCheck();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i : arr) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(arr));
    }

    /**
     * TODO N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고, N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
     */
    public String mySolution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        return set.size() == arr.length ? "U" : "D";
    }

    public String solution(int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return answer;
    }
}

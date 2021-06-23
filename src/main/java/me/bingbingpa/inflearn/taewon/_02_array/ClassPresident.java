package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        ClassPresident T = new ClassPresident();
        int[][] arr = new int[][]{
                {2, 3, 1, 7, 3},
                {4, 1, 9, 6, 8},
                {5, 5, 2, 4, 4},
                {6, 5, 2, 6, 7},
                {8, 4, 2, 2, 2}
        };
        System.out.println(T.solution(arr));

    }

//    public static void main(String[] args) {
//        ClassPresident T = new ClassPresident();
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[][] arr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = scanner.nextInt();
//            }
//        }
//        System.out.println(T.solution(arr));
//    }

    /**
     * TODO  2-11. 임시반장 정하기: 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
     */
    public int solution(int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i + 1;
            }
        }

        return answer;
    }
}

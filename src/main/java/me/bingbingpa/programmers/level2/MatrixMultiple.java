package me.bingbingpa.programmers.level2;

import java.util.Arrays;

public class MatrixMultiple {

    public static void main(String[] args) {
        MatrixMultiple T = new MatrixMultiple();
        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};
        System.out.println(Arrays.deepToString(T.solution(arr1, arr2)));
    }

    /**
     * 행렬의 곱셈
     * https://programmers.co.kr/learn/courses/30/lessons/12949
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int n = arr1[0].length;
        int[][] answer = new int[m][arr2[0].length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        return answer;
    }
}

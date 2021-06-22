package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class GridMaxSum {
//    public static void main(String[] args) {
//        GridMaxSum T = new GridMaxSum();
//        int[][] grid = new int[][]{
//                {10, 13, 10, 12, 15},
//                {12, 39, 30, 23, 11},
//                {11, 25, 50, 53, 15},
//                {19, 27, 29, 37, 27},
//                {19, 13, 30, 13, 19}
//        };
//        System.out.println(T.mySolution(grid));
//    }

    public static void main(String[] args) {
        GridMaxSum T = new GridMaxSum();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        System.out.println(T.mySolution(grid));
    }

    /**
     * TODO N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력하세요.
     * [문제풀이]
     * 각 행: (0,0), (0,1), (0,2) ...
     * 각 열: (1,0), (2,0), (3,0) ...
     * 대각선 아래로: (0,0), (1,1), (2,2) ...
     * 대각선 위로: (0,4), (1,3), (2,2), (3,1), (4,0)
     */
    public int mySolution(int[][] grid) {
        int answer = 0;
        int rowSum = 0;
        int colSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowSum += grid[i][j];
                colSum = grid[j][i];
            }
            answer = Math.max(answer, rowSum);
            answer = Math.max(answer, colSum);
            rowSum = 0;
            colSum = 0;
        }

        int diagonalBottom = 0;
        int diagonalUp = 0;
        for (int i = 0; i < grid.length; i++) {
            diagonalBottom += grid[i][i];
            diagonalUp += grid[i][grid.length - i - 1];
        }
        answer = Math.max(diagonalBottom, answer);
        answer = Math.max(diagonalUp, answer);

        return answer;
    }

    public int solution(int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1;
        int sum2;

        for (int i = 0; i < arr.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1+=arr[i][i];
            sum2 += arr[i][arr.length - i - 1];
        }

        return answer;
    }
}

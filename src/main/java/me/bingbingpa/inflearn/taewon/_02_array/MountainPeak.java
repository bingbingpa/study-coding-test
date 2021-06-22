package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class MountainPeak {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    //    public static void main(String[] args) {
//        MountainPeak T = new MountainPeak();
//        int[][] grid = new int[][]{
//                {5, 3, 7, 2, 3},
//                {3, 7, 1, 6, 1},
//                {7, 2, 5, 3, 4},
//                {4, 3, 6, 4, 1},
//                {8, 7, 3, 5, 2}
//        };
//        System.out.println(T.solution(grid));
//    }
    public static void main(String[] args) {
        MountainPeak T = new MountainPeak();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println(T.solution(grid));
    }


    /**
     * TODO 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
     * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
     */
    public int solution(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] >= grid[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

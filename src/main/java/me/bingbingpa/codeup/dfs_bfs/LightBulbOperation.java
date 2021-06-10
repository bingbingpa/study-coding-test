package me.bingbingpa.codeup.dfs_bfs;

public class LightBulbOperation {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0}
        };

        System.out.println("result ============= " + solution(grid)); //output: 4 2
    }

    /**
     * TODO m*n 의 전광판에서 켜져 있거나 꺼져 있는 전구들을 조작하여 모두 켜진 상태가 되도록 하는 최소 조작횟수와 모든 꺼진 상태로 되도록 하는 최소조작횟수를 찾는 프로그램을 작성하라.
     * 코드업 4060:전광판 전구 조작(https://codeup.kr/problem.php?id=4060)
     * 끄는 동작을 할때에는 스위치를 계속 끄고, 켜는 동작을 할 때에는 계속 켤 때의 최소 조작 횟수입니다.
     * 0 은 꺼진 상태, 1은 켜진 상태
     * 2<=M,N<=100인 자연수
     */
    public static String solution(int[][] grid) {
        if (isValid(grid)) {
            return null;
        }
        int m = grid.length;
        int n = grid[0].length;
        int onCount = 0;
        int offCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, 0, i, j)) {
                    onCount++;
                }
                if (dfs(grid, 1, i, j)) {
                    offCount++;
                }
            }
        }

        return getResult(onCount, offCount);
    }

    private static boolean dfs(int[][] grid,int value, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != value) {
            return false;
        }

        grid[i][j] = 10;
        dfs(grid, value, i - 1, j);
        dfs(grid, value, i + 1, j);
        dfs(grid, value, i, j - 1);
        dfs(grid, value, i, j + 1);

        return true;
    }

    private static String getResult(int onCount, int offCount) {
        return onCount + " " + offCount;
    }

    private static boolean isValid(int[][] grid) {
        return grid == null || grid.length == 0 || grid[0].length == 0;
    }
}

package me.bingbingpa.inflearn.basic._06_bfs_dfs;

public class DFSMemoization {
    public static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] grid = {
                {9, 8, 3},
                {6, 5, 7},
                {2, 1, 1}};

        System.out.println("result ======================== " + solve(grid));
    }

    public static int solve(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 1;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, result);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] result) {
        if (result[i][j] != 0) {
            return result[i][j];
        }
        int max = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, m, n, result);
            max = Math.max(max, len);
        }
        result[i][j] = max;

        return max;
    }
}

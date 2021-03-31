package me.bingbingpa.inflearn.basic._06_bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSCountAreaSize {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static boolean[][] visited;
    static int m = 0;
    static int n = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 3, 3},
                {1, 4, 0, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 2, 2, 0},
                {1, 1, 0, 0}};
        System.out.println("result =================== " + Arrays.toString(solve(grid)));
    }

    public static int[] solve(int[][] grid) {
        if (grid == null | grid.length == 0) {
            return new int[]{0, 0};
        }

        int count = 0;
        int maxSize = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                count++;
                int thisAreaSize = bfs(grid, i, j,  visited);
                maxSize = Math.max(maxSize, thisAreaSize);
            }
        }
        int[] result = new int[2];
        result[0] = count;
        result[1] = maxSize;

        return result;
    }

    public static int bfs(int[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int thisNumAreaSize = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            thisNumAreaSize++;
            visited[i][j] = true;

            for (int[] dir : dirs) {
                int newX = point[0] + dir[0];
                int newY = point[1] + dir[1];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                    if (!visited[newX][newY] && grid[i][j] == grid[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return thisNumAreaSize;
    }
}

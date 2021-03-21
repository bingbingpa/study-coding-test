package me.bingbingpa.ch06;

import java.util.LinkedList;
import java.util.Queue;

public class BasicBFS {
    public static void main(String[] args) {
        BasicBFS basicBFS = new BasicBFS();
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("result ========================= " + basicBFS.bfs(grid));
    }
    int m = 0;
    int n = 0;
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int bfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        m = grid.length; // row 4
        n = grid[0].length; // col 5

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y}); // 0, 0

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] dir : dirs) {
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                if (x1 >= 0 && y1 >= 0 && m > x1 && n > y1 && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
    }
}

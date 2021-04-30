package me.bingbingpa.inflearn.practice._04_graph;

public class MaxOfIslands {
    public static void main(String[] args) {
        MaxOfIslands maxOfIslands = new MaxOfIslands();
        int[][] grid = {
                        {1, 1, 0, 1, 1},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1}
        };
        System.out.println("result ================ " + maxOfIslands.solution(grid));
    }

    /**
     * TODO 2차원배열 그리드가 0과 1 인 경우(1이 육지(섬) 0이 바다) 최대 면적을 구하라.
     */
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, 0);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int x, int y, int area) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return area;
        }

        grid[x][y] = 0;
        area++;

        for (int[] dir : dirs) {
            area = dfs(grid, x + dir[0], y + dir[1], area);
        }

        return area;
    }

}

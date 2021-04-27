package me.bingbingpa.inflearn.practice._04_graph;

public class NumberOfIsland_dfs {
    public static void main(String[] args) {
        NumberOfIsland_dfs numberOfIsland_dfs = new NumberOfIsland_dfs();
        char[][] grid= {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("result ================= " + numberOfIsland_dfs.solution(grid)); // output 3
    }

    /**
     * TODO 1(토지) 과 0(물) 의 2D 그리드 맵이 주어졌을 때 섬에 해당하는 영역의 수를 구하라.
     */
    public int solution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
            System.out.println();
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

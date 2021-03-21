package me.bingbingpa.ch06;

public class BasicDFS {

    int m = 0;
    int n = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        BasicDFS basicDFS = new BasicDFS();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println("result ================== " + basicDFS.numsIslands(grid));
    }

    public int numsIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || m <= i || n <= j || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

//        dfs(grid, i-1, j);
//        dfs(grid, i+1, j);
//        dfs(grid, i, j-1);
//        dfs(grid, i, j+1);

        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}

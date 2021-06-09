package me.bingbingpa.codeup.dfs_bfs;

public class Candypang {
    public static void main(String[] args) {
        Candypang candypang = new Candypang();
//        int[][] grid = {
//                {2, 1, 5, 1, 1, 3, 4},
//                {2, 1, 5, 1, 3, 5, 3},
//                {2, 3, 4, 5, 2, 2, 4},
//                {4, 4, 3, 2, 3, 1, 3},
//                {4, 3, 5, 3, 1, 4, 3},
//                {5, 4, 4, 3, 3, 5, 5},
//                {2, 1, 3, 5, 1, 1, 2}
//        };

        int[][] grid = {
                {4, 4, 4, 4, 1, 4, 3},
                {4, 4, 4, 4, 3, 2, 4},
                {4, 4, 4, 4, 5, 5, 4},
                {4, 4, 4, 4, 2, 1, 3},
                {5, 5, 3, 2, 4, 4, 4},
                {2, 1, 1, 3, 4, 4, 4},
                {5, 4, 5, 5, 4, 4, 4}
        };
        System.out.println("result ================== " + candypang.solution(grid)); // output: 2

    }

    /**
     * 주어진 그리드에서 같은 색깔이 연속 3개 이상인 부분의 수를 구하라.(캔디팡)
     * 테스트
     * input value validation
     * grid 를 모두 출력해본다.
     * grid 를 깊이 우선 탐색으로 출력해본다.
     * grid 를 깊이 우선 탐색으로 순회하면서 이전 값과 같은지 확인해본다.
     */
    public int solution(int[][] grid) {
//        testIsValid();
        if (isValid(grid)) {
            throw new IllegalArgumentException("입력 값은 m*n 의 배열이어야 합니다.(m > 0, n > 0)");
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
//        print(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                if (grid[i][j] != 0) {
                    temp = dfs(grid, i, j, grid[i][j]);
                }
                if (temp >= 3) {
                    count++;
                }
            }
        }

        return count;
    }

    private int dfs(int[][] grid, int i, int j, int color) {
        if (isOutOfBind(grid, i, j)) {
            return 0;
        }
//        System.out.print("[" + i + "]" + "[" + j + "]==" + grid[i][j] + "  ");
//        System.out.println(", color ==== " + color);
        if (grid[i][j] == color) {
            grid[i][j] = 0;
        } else {
            return 0;
        }
        // 상하좌우 순회
        return 1 + dfs(grid, i - 1, j, color) + dfs(grid, i + 1, j, color) + dfs(grid, i, j - 1, color) + dfs(grid, i, j + 1, color);
    }

    private boolean isValid(int[][] grid) {
        return grid == null || grid.length == 0 || grid[0].length == 0;
    }

    private void testIsValid() {
        System.out.println("grid null, expected: true, result === " + (isValid(null)));
        System.out.println("grid length == 0, expected: true, result === " + (isValid(new int[][]{})));
        System.out.println("grid length == 1, expected: false, result === " + (isValid(new int[][]{{1}, {2}})));
    }

    private boolean isOutOfBind(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        return i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0;
    }

    private void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]==" + grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

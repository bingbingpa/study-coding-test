package me.bingbingpa.inflearn.practice._04_graph;

public class MazeDFS {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
//		int[] dest = {4,4};
        int[] dest = {3, 2};
        System.out.println("result ======== " + solution(maze, start, dest));
    }

    /**
     * TODO 주어진 2차원 배열에서 시작 지점에서 도착 지점에 공이 멈출 수 있는지 판별하라.(DFS)
     * 1은 벽, 0은 빈 공간
     * 공은 상하좌우 방향으로 갈 수 있고 벽을 만나면 멈춘다.
     */
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int m;
    static int n;
    public static boolean solution(int[][] maze, int[] start, int[] dest) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        return dfs(maze, start, dest, visited);
    }

    private static boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]]) {
            return false;
        }
        visited[start[0]][start[1]] = true;
        if (start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }

        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if (dfs(maze, new int[]{x, y}, dest, visited)) {
                return true;
            }
        }
        return false;
    }
}

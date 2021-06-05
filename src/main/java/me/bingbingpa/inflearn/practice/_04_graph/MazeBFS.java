package me.bingbingpa.inflearn.practice._04_graph;

import java.util.LinkedList;
import java.util.Queue;

public class MazeBFS {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
		int[] dest = {4,4};
//        int[] dest = {3, 2};
        System.out.println("result ======== " + solution(maze, start, dest));
    }

    /**
     * TODO 주어진 2차원 배열에서 시작 지점에서 도착 지점에 공이 멈출 수 있는지 판별하라.(BFS)
     * 1은 벽, 0은 빈 공간
     * 공은 상하좌우 방향으로 갈 수 있고 벽을 만나면 멈춘다.
     */
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int m;
    static int n;
    public static boolean solution(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;
        if (start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (x == dest[0] && y == dest[1]) {
                    return true;
                }
                queue.offer(new int[]{x, y});
            }
        }
        return false;
    }
}

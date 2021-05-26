package me.bingbingpa.codeup.basic100;

public class AntMovementPath {
    public static void main(String[] args) {
        int[][] path = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 2, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        print(path);
        solution(path);
        System.out.println("===========================");
        print(path);
    }

    /**
     * TODO 개미가 이동한 경로를 9로 표시해 출력하라.
     * 개미는 오른쪽으로 움직이다가 벽을 만나면 아래쪽으로 움직여 가장 빠른 길로 움직인다. (오른쪽에 길이 나타나면 다시 오른쪽으로 움직인다.)
     * 미로 상자의 구조가 0(갈 수 있는 곳), 1(벽 또는 장애물)로 주어지고, 먹이가 2로 주어진다.
     *
     */
    public static void solution(int[][] path) {
        int startX = 1;
        int startY = 1;
        int m = path.length;
        int n = path[0].length;
        for (; startX < m; startX++) {
            if (path[startX][startY] == 2) {
                path[startX][startY] = 9;
                break;
            }
            for (; startY < n; startY++) {
                if (path[startX][startY] == 0) {
                    path[startX][startY] = 9;
                } else {
                    startY--;
                    break;
                }
            }
        }
    }

    public static void print(int[][] path) {
        int n = path[0].length;
        for (int[] ints : path) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}

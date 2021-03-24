package me.bingbingpa.inflearn.basic.ch03;

public class Array2D {

    public static void main(String[] args) {
        // 1. 2차원 배열의 크기가 같다.
        int[][] grid = new int[3][4];
        System.out.println("======= 1번 =======");
        print(grid);

        grid[0][1] = 16;
        System.out.println("=======after=======");
        print(grid);

        // 2. 2차원 배열의 크기가 다른 경우
        int[][] grid2 = new int[3][];
        System.out.println("======= 2번 =======");
        grid2[0] = new int[1];
        grid2[1] = new int[1];
        grid2[2] = new int[5];
        System.out.println("=======after=======");
        print(grid2);

        // 3. 초기화와 동시에 값을 넣을 때
        int[][] grid3 = {{1, 2},
                {0, 0, 3},
                {4, 5, 6}};
        System.out.println("=======3  after=======");
        print(grid3);
    }

    public static void print(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

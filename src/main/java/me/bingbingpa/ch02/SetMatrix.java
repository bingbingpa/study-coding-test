package me.bingbingpa.ch02;

import java.util.HashSet;
import java.util.Set;

public class SetMatrix {
    /**
     * ===================Problem===================
     * - 주어진 행렬 m*n. 요소가 0 이면 전체 행과 열을 0으로 설정 합니다.
     * ===================Example===================
     * Input: matrix = [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * Output:
     * [[1,0,1],
     * [0,0,0],
     * [1,0,1]]
     */

    public static void main(String[] args) {
        SetMatrix setMatrix = new SetMatrix();
        int[][] grid = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        setMatrix.print(grid);
        setMatrix.solve(grid);
        System.out.println("=========result===========");
        setMatrix.print(grid);
    }

    public void solve(int[][] grid) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    public void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("["+i+"]["+j+"] "+grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}

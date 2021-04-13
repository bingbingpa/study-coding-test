package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("result =============== " + spiralMatrix.solution(input));

    }

    /**
     * TODO m * n 요소의 행렬(m 행, n 열) 이 주어지면 나선 순서로 행렬의 모든 요소를 반환하라.
     * 예) input: [[1,2,3],[4,5,6],[7,8,9]], output: [1,2,3,6,9,8,7,4,5]
     */
    public List<Integer> solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowStart = 0 ;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for(int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for(int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            if (rowStart <= rowEnd) {
                for(int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // up
            if (colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[rowEnd][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }
}

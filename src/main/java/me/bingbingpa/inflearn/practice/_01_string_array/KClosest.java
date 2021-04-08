package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.*;

public class KClosest {
    public static void main(String[] args) {
        KClosest closest = new KClosest();
        int[][] points = {{1, 3}, {-2, 2}};
        closest.print(points);
        int k = 1;
        System.out.println("result ================== " + Arrays.deepToString(closest.solution(points, k)));
    }

    /**
     * TODO 주어진 포인트에서 원점(0,0) 과 가까운 k 개의 포인트를 구하라.
     * 예) input: points=[[1,3],[-2,2]], k=1, output: [[-2,2]]
     */
    public int[][] solution(int[][] points, int k) {
        // 원점 구하는 공식 (X2 - X1)² + (Y2 - Y1)²
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        int[][] result = new int[k][2];

        for (int[] p : points) {
            pq.offer(p);
        }

        int index = 0;
        while (index < k) {
            result[index] = pq.poll();
            index++;
        }

        return result;
    }

    private void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
            }
            System.out.println();
        }
    }
}

package me.bingbingpa.inflearn.taewon._06_sorting_searching;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoordinateSort {
//    public static void main(String[] args) {
//        List<Point> result = new ArrayList<>();
//        result.add(new Point(2, 7));
//        result.add(new Point(1, 3));
//        result.add(new Point(1, 2));
//        result.add(new Point(2, 5));
//        result.add(new Point(3, 6));
//        Collections.sort(result);
//
//        for (Point point : result) {
//            System.out.println(point.getX() + " " + point.getY());
//        }
//    }

    public static void main(String[] args) {
        List<Point> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            result.add(new Point(x, y));
        }
        Collections.sort(result);

        for (Point point : result) {
            System.out.println(point.getX() + " " + point.getY());
        }
    }

    /**
     * TODO N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
     */
    static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.x == point.x) {
                return this.y - point.y;
            } else {
                return this.x - point.x;
            }
        }
    }
}

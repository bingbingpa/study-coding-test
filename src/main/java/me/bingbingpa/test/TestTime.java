package me.bingbingpa.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestTime {

    public static void main(String[] args) {
        solution(5, new int[]{2, 3, 1, 5});
    }

    public static int solution(int X, int[] A) {
        // Test
        boolean testExcute = true;
        if (testExcute) {
            // condition : ...
            assertThat(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6);
            // impossible
            assertThat(5, new int[]{1, 2}, -1);
        }
        return _solution(X, A);
    }

    private static int _solution(int X, int[] A) {
        // implement
        /*FrogRiverOne
        Find the earliest time when a frog can jump to the other side of a river.*/
        // 요소는 거리, 인덱스는 시간
        Set<Integer> dist = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            // 가야할 거리를 도달 했는지...
            if (A[i] <= X) {
                dist.add(A[i]); // 현재까지 진행거리 합
                if (dist.size() == X) {
                    // 거리 도착
                    return i; // 소요시간
                }
            }
        }
        return -1;
    }

    private static void assertThat(int X, int[] A, int expected) {
        long beforeTime = System.currentTimeMillis();
        int rst = _solution(X, A);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("time : " + secDiffTime + " ms");
        System.out.println(Arrays.toString(A) + "  ->  " + rst + "(expected :: " + expected + ")");
        boolean rtn = rst == expected;
        System.out.println(!rtn ? "It's got some errors." : "Test OK");
    }

}

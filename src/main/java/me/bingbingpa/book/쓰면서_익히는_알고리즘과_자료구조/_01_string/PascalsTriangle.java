package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println("result ================= " + solution(3));
    }

    /**
     * TODO numRows 에 해당하는 크기의 파스칼의 삼각형을 구하라.
     * 파스칼의 삼각형은 처음 두 줄을 제외하고 새로 만들어지는 줄의 새로운 숫자는 윗줄의 왼쪽수와 오른쪽 수를 더해 만들어 진다.
     * 제일 맨 첫 줄 하나의 숫자는 1이다.
     * 항상 맨 앞과 맨 뒤의 값은 1이다.
     */
    public static List<List<Integer>> solution(int numRows) {
        // 시간 복잡도 O(n²)
        // 공간 복잡도 O(1)
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows <= 0) {
            return pascal;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        pascal.add(first);

        for (int i = 1; i < numRows; i++) {
            int prevLen = pascal.get(i - 1).size();
            List<Integer> currList = new ArrayList<>();

            for (int j = 0; j < prevLen + 1; j++) {
                int num = 1;
                if (j != 0 && j != prevLen) {
                    num = pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j);
                }
                currList.add(num);
            }
            pascal.add(currList);
        }

        return pascal;
    }
}

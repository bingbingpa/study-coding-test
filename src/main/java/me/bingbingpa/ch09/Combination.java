package me.bingbingpa.ch09;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        /**
         * ===================Problem===================
         * Input: n = 3, k = 2 // n 개의 연속된 숫자가 k 가 만큼 겹치지 않는 모든 경우 리턴
         * Output: [[1,2], [1,3], [2,3]]
         */
        int n = 3;
        int k = 2;

        System.out.println("result ==========================" + solve(n, k));
    }

    public static List<List<Integer>> solve(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        backtrack(result, tempList, n, k, 1);

        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
        if(tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i <= n; i++) {
                tempList.add(i);
                backtrack(result, tempList, n, k, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

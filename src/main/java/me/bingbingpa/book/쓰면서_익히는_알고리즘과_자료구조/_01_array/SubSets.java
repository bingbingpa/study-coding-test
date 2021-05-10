package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        System.out.println("result ============= " + solution(Arrays.asList(1,2,3)));
    }

    /**
     * TODO 고유한 정수의 집합으로 배열이 주어지면 가능한 모든 부분집합을 반환하라.
     * 중복된 부분집합은 허용하지 않는다.
     * 예) input: [1,2,3], output: [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
     */
    public static List<List<Integer>> solution(List<Integer> nums) {
        // 시간 복잡도: O(N*2^n)
        // 공간 복잡도: O(N*2^n)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        recursion(nums, result, sub, 0);

        return result;
    }

    public static void recursion(List<Integer> nums, List<List<Integer>> res, List<Integer> sub, int index) {
        if (sub.size() > nums.size()) {
            return;
        }

        res.add(new ArrayList<>(sub));

        int length = nums.size();
        for (int i = index; i < length; i++) {
            sub.add(nums.get(i));
            recursion(nums, res, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}

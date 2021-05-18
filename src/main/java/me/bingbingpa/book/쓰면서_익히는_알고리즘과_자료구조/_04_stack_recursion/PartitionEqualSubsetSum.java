package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._04_stack_recursion;

import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {
    static int minDiff = Integer.MAX_VALUE;
    static int total = 0;

    public static void main(String[] args) {
        System.out.println("result ============ " + solution(new int[]{3, 2, 7, 4, 1}));
    }

    /**
     * 배열을 두 부분집합으로 만들고 각 부분집합의 합 차이가 최소가 되는 값을 반환하라
     */
    public static int solution(int[] nums) {
        total = IntStream.of(nums).sum();
        subsetDiff(0, nums, 0);

        return minDiff;
    }

    public static void subsetDiff(int index, int[] nums, int subsum) {
        if (index == nums.length) {
            minDiff = Math.min(minDiff, Math.abs((total - subsum) - subsum));
            return;
        }
        subsetDiff(index + 1, nums, subsum + nums[index]);
        subsetDiff(index + 1, nums, subsum);
    }
}

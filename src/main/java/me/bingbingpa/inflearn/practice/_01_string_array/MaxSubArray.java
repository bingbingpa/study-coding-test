package me.bingbingpa.inflearn.practice._01_string_array;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println("result ========== " + maxSubArray.solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * TODO 정수 배열에서 가장 값이 큰(적어도 하나의 숫자 포함) subarray 합계를 반환하라.
     * 예) input: [-2,1,-3,4,-1,2,1,-5,4], output: 6
     * 설명) [4,-1,2,1] 을 더해서 합계 6
     */
    public int solution(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(nums[i], newSum + nums[i]);
            max = Math.max(newSum, max);
        }
        return max;
    }
}

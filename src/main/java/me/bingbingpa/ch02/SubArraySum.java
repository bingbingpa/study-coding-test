package me.bingbingpa.ch02;

public class SubArraySum {
    /**
     * ===================Problem===================
     * Integer array nums, k 가 있다.
     * return the total number of continuous subarrays
     * whose sum equals to k.
     * ===================Example===================
     * 입력 : int[] nums= { 3, 4, 7, 2, -3, 1, 4, 2 };
     * int k=7
     * 출력 : 4
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println("result ================ " + subArraySum(nums, k));
    }

    public static int subArraySum(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum = sum + nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

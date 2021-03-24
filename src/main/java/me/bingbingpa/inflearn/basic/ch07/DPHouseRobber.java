package me.bingbingpa.inflearn.basic.ch07;

public class DPHouseRobber {
    /**
     * ===================Problem===================
     * Input: int[] nums = {2,7,9,3,1,8}
     * Output: 19 (2+9+1+8)
     * 인접한 두 집에 침입하면 경찰에 자동으로 연락된다.
     * 각 House 의 금액은 자연수로 주어진다.
     *
     */
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1,8};
        System.out.println("result ================ " + solve(nums));
    }

    public static int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + val);
            // dp[3] = max(dp[2], dp[1]+ 9
        }
        print(dp);
        return dp[nums.length];

    }

    public static void print(int[] dp) {
        for(int i : dp)
            System.out.println(i);
    }
}

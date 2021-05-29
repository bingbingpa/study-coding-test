package me.bingbingpa.codeup.recursion;

public class ClimbingStairs {
    static int[] nums = new int[100001];

    public static void main(String[] args) {
        System.out.println("result ============ " + solution(5)); // 13
    }

    /**
     * TODO 계단을 한번에 1계단 2계단 또는 3계단씩 오를 때 주어진 수 N 개의 계단을 오를 수 잇는 경우의 수를 1000 으로 나눈 나머지를 구하라.
     */
    public static int solution(int n) {
        if (n >= 100000 || n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            if (nums[n] == 0) {
                nums[n] = (solution(n - 1) + solution(n - 2) + solution(n - 3)) % 1000;
            }
            return nums[n];
        }
    }
}
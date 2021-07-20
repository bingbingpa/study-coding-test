package me.bingbingpa.inflearn.taewon._08_dfs_bfs_practice;

import java.util.Scanner;

public class SameSumSubset {

    //    public static void main(String[] args) {
//        SameSumSubset T = new SameSumSubset();
//        System.out.println(T.mySolution(new int[]{1, 3, 5, 6, 7, 10}));
//    }
    static String answer = "NO";
    static int total = 0;
    boolean flag = false;
    public static void main(String[] args) {
        SameSumSubset T = new SameSumSubset();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            total += nums[i];
        }

        T.dfs(0, 0, nums);
        System.out.println(answer);
    }

    /**
     * TODO 주어진 자연수 집합을 두 부분집합으로 나누었을 때 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
     */
    private void dfs(int level, int sum, int[] nums) {
        if (flag || sum > total / 2) {
            return;
        }
        if (level == nums.length) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(level + 1, sum + nums[level], nums);
            dfs(level + 1, sum, nums);
        }
    }
}

package me.bingbingpa.inflearn.taewon._08_dfs_bfs_practice;

import java.util.Scanner;

public class DogRide {

    static int answer = 0;
    static int weight = 259;
//    public static void main(String[] args) {
//        DogRide T = new DogRide();
//        T.dfs(0, 0, new int[] {81, 58, 42, 33, 61});
//        System.out.println(answer);
//    }

    public static void main(String[] args) {
        DogRide T = new DogRide();
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextInt();
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        T.dfs(0, 0, arr);
        System.out.println(answer);
    }

    /**
     * TODO N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
     */
    public void dfs(int level, int sum, int[] nums) {
        if (sum > weight) {
            return;
        }
        if (level == nums.length) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + nums[level], nums);
            dfs(level + 1, sum, nums);
        }
    }
}

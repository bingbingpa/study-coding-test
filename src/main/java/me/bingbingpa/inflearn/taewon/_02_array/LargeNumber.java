package me.bingbingpa.inflearn.taewon._02_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargeNumber {
//    public static void main(String[] args) {
//        LargeNumber T = new LargeNumber();
//        T.solution(6, new int[]{7, 3, 9, 5, 6, 12});
//    }

    public static void main(String[] args) {
        LargeNumber T = new LargeNumber();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        T.solution(n, nums);
    }

    /**
     * TODO N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
     * (첫 번째 수는 무조건 출력한다)
     * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
     */
    public void solution(int n, int[] nums) {
        if (isValid(nums)) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                result.add(nums[i]);
            }
        }

        for (Integer num : result) {
            System.out.printf(num + " ");
        }
    }

    private boolean isValid(int[] nums) {
        return nums.length == 0;
    }
}

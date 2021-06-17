package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class VisibleStudent {
//    public static void main(String[] args) {
//        VisibleStudent T = new VisibleStudent();
//        System.out.println(T.mySolution(8, new int[]{130, 135, 148, 140, 145, 150, 150, 153}));
//    }

    public static void main(String[] args) {
        VisibleStudent T = new VisibleStudent();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(T.mySolution(n, nums));
    }

    /**
     * TODO 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
     * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
     * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     */
    public int mySolution(int n, int[] nums) {
        isValid(n, nums);

        int count = 1;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                count++;
                max = nums[i];
            }
        }

        return count;
    }

    private void isValid(int n, int[] nums) {
        if (n <= 5 || n > 100000) {
            throw new IllegalArgumentException("학생의 수는 5보다 크고 100000 보다 작아야 합니다.");
        }

        if (nums.length == 0 || nums.length != n) {
            throw new IllegalArgumentException("키 배열은 학생 수와 같아야 합니다.");
        }
    }
}

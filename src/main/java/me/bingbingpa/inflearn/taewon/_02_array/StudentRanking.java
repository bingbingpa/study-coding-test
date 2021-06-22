package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class StudentRanking {
//    public static void main(String[] args) {
//        StudentRanking T = new StudentRanking();
//        int[] result = T.mySolution(new int[]{87, 89, 92, 100, 76});
//        for (int i : result) {
//            System.out.printf(i + " ");
//        }
//    }

    public static void main(String[] args) {
        StudentRanking T = new StudentRanking();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] result = T.mySolution(nums);
        for (int i : result) {
            System.out.printf(i + " ");
        }
    }

    /**
     * TODO N 명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
     * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
     */
    public int[] mySolution(int[] nums) {
        int[] answer = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            answer[i] = 1;
            for (int num : nums) {
                if (nums[i] < num) {
                    answer[i] = answer[i] + 1;
                }
            }
        }

        return answer;
    }
}

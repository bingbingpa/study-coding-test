package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println("result =========== " + Arrays.toString(solution3(new int[]{1, 2, 3, 4}, 2)));
    }

    /**
     * TODO 입력으로 정수형 배열과 k 값이 주어지면, 각 요소를 우측으로 k 번 이동 및 회전하라.
     * k 는 양의 정수 값이다.
     * 예) nums: [1,2,3,4], k: 1, output: [4,1,2,3]
     */
    public static int[] solution1(int[] nums, int k) {
        // 시간 복잡도 O(N*K)
        // 공간 복잡도 O(1)
        for (int i = 0; i < k; i++) {
            int length = nums.length;
            int prev = nums[length - 1];
            for (int j = 0; j < length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
        return nums;
    }

    public static int[] solution2(int[] nums, int k) {
        // 시간 복잡도 O(N)
        // 공간 복잡도 O(N)
        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }
        return temp;
    }

    public static int[] solution3(int[] nums, int k) {
        // 시간 복잡도 O(N)
        // 공간 복잡도 O(1)
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (count >= length) {
                break;
            }
            int currIndex = i;
            int prevElem = nums[i];

            while (true) {
                int nextIndex = (currIndex + k) % length;
                int temp = nums[nextIndex];
                nums[nextIndex] = prevElem;
                prevElem = temp;

                currIndex = nextIndex;
                count++;

                if (currIndex == i) {
                    break;
                }
            }
        }
        return nums;
    }
}

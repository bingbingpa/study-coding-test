package me.bingbingpa.inflearn.practice._01_string_array;

import me.bingbingpa.test.CustomTest;
import me.bingbingpa.test.TestUnit;

import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
//        int[] nums = {3,2,1,5,6,4};
//        int k =2; //output: 5
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4; //output: 4
        System.out.println("result ================== " + kthLargest.solution2(nums, k));
    }

    /**
     * TODO 정렬되지 않은 배열에서 정렬된 순서에서 k 번째로 큰 요소를 찾아라.
     * 예) input: nums:[3,2,1,5,6,4], k:2, output: 5
     * TEST
     * - 배열의 각 요쇼들을 정렬한다.
     * - 두 수중에서 더 작은 값을 찾는다.
     * - 배열을 마지막부터 돌면서 작은 값을 찾는다.
     * - 가장 작은 값이 바뀔 때 마다 count 를 증가시킨다.
     */
    public int solution1(int[] nums , int k) {
        if (nums.length == 0) {
            return 0;
        }
        TestUnit.test(this.getClass());
        Arrays.sort(nums);

        int count = 1;
        int length = nums.length-1;
        int min = nums[length];
        for (int i = length; i > 0; i--) {
            int temp = findMaxNumber(nums[i], nums[i - 1]);
            if (min >= temp) {
                min = temp;
                count++;
            }

            if (count == k) {
                break;
            }
        }

        return min;
    }

    public int solution2(int[] nums , int k) {
        int length = nums.length;
        Arrays.sort(nums);

        return nums[length - k];
    }

    @CustomTest
    public void testFindMaxNumber() {
        TestUnit.printMessage(1 == findMaxNumber(1, 2));
        TestUnit.printMessage(3 == findMaxNumber(3, 9));
        TestUnit.printMessage(1 == findMaxNumber(1, 1));
    }

    private int findMaxNumber(int num1, int num2) {
        return Math.min(num1, num2);
    }
}

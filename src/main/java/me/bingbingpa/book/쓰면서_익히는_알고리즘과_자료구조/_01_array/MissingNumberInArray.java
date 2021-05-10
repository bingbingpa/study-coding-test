package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumberInArray {
    public static void main(String[] args) {
        System.out.println("result =========== " + solution4(new int[]{3, 1, 0}));
    }

    /**
     * TODO 주어진 정수형 배열이 0 ~ n 까지 숨자를 담고 있을 때 이 중 빠진 숫자를 찾아서 리턴하라.
     * 배열의 값은 0에서 시작하여 n 까지 n+1 개의 요소를 가질 수 있지만, 배열의 크기는 n 으로 이 숫자 중 하나는 빠져 있다는 의미이다.
     * 예) input: [3,1,0], output: 2
     */
    public static int solution1(int[] nums) {
        // 시간 복잡도: O(NlogN)
        // 공간 복잡도: O(1)
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[length - 1] != length) {
            return length;
        }
        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < length; i++) {
            int expected = nums[i - 1] + 1;
            if (expected != nums[i]) {
                return expected;
            }
        }

        return -1;
    }

    public static int solution2(int[] nums) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N)
        Set<Integer> setNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int size = setNums.size();
        for (int i = 0; i < size; i++) {
            if (!setNums.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static int solution3(int[] nums) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        int missing = nums.length;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            missing = missing ^ i ^ nums[i];
        }

        return missing;
    }

    public static int solution4(int[] nums) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        int expectedSum = 0;
        int numsSum = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            expectedSum += i;
        }

        for (int num : nums) {
            numsSum += num;
        }
        return expectedSum - numsSum;
    }
}

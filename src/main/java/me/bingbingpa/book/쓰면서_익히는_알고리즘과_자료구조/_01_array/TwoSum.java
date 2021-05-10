package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 10, 19};
        int target = 9;
        System.out.println("result ============= " + Arrays.toString(solution2(nums, target)));
    }

    /**
     * TODO 주어진 정수형 배열에서 2개의 숫자를 선택하여 더한 값이 특정 목푯값(Target)을 만들 때, 그 선택한 2개의 정수가 있는 배열의 인덱스를 반환하는 프로그램을 작성하라.
     * 입력값으로 주어지는 배열에는 하나의 정답이 존재하며, 같은 요소의 값을 중복해서 사용할 수 없다.
     */
    private static int[] solution1(int[] nums, int target) {
        // 시간 복잡도: O(N²)
        // 공간 복잡도: O(1)
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    private static int[] solution2(int[] nums, int target) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N)
        Map<Integer, Integer> map = new HashMap<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int findNumber = target - nums[i];
            if (map.containsKey(findNumber) && map.get(findNumber) != i) {
                return new int[]{i, map.get(findNumber)};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}

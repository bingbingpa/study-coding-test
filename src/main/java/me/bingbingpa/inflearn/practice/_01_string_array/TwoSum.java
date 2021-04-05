package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 8, 11, 14};
        int target = 16;
        System.out.println("result ================== " + Arrays.toString(twoSum.solution2(nums, target)));
    }

    /**
     * TODO 주어진 배열의 값 2개를 더해서 target 의 값이 되는 곳의 위치를 배열로 리턴하라.
     * 예) input: [2,8,11,14], target 16
     * output: [1,4]
     */
    public int[] solution1(int[] nums, int target) {
        // 시간 복잡도 O(n²)
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
            }
        }

        return result;
    }

    public int[] solution2(int[] nums, int target) {
        // 시간 복잡도 O(n)
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]) + 1;
                result[1] = i + 1;
            } else {
                map.put(target - nums[i], i);
            }
        }

//        for (Integer key : map.keySet()) {
//            System.out.println("key ============== " + key);
//        }

        return result;
    }
}

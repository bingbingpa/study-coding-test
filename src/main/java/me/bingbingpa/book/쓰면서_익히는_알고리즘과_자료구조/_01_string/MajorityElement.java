package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println("result =============== " + solution3(new int[]{8, 3, 5, 3, 3})); // output: 3
    }

    /**
     * TODO 정수형 배열이 주어졌을 때 다수의 요소를 찾아서 리턴하라.
     * 다수의 요소는 배열 내에서 n/2 을 초과하여 나타나는 요소를 말하고 배열은 항상 1개 이상의 요소를 가지고 있으며 다수의 수가 무조건 하나 존재한다고 가정한다.
     * 예를 들어 배열 요소 총개수가 9개라면 n/2 는 4.5다. 결국 5번 이상 나타나는 요소를 찾으면 된다.
     * 예) input: [2,1,2], output: 2
     */
    public static int solution1(int[] nums) {
        // 시간 복잡도 O(N²)
        // 공간 복잡도 O(1)
        int length = nums.length;
        int majorityCount = length / 2;
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = i ;j < length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
                if (count > majorityCount) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int solution2(int[] nums) {
        // 시간 복잡도 O(N)
        // 공간 복잡도 O(N)
        int length = nums.length;
        int majorityCount = length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    public static int solution3(int[] nums) {
        // 시간 복잡도 O(NlogN)
        // 공간 복잡도 O(1)
        int majorityCount = nums.length / 2;

        Arrays.sort(nums);
        return nums[majorityCount];
    }
}

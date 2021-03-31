package me.bingbingpa.inflearn.basic._04_map;

import java.util.*;

public class MapArray {
    /**
     * ===================Problem===================
     * - 배열이 주어지면 가장 빈도수가 높은 k 개의 요소를 return
     * ===================Example===================
     * Input int[] nums = {1,1,2,2,2,3,5,5,5,5};
     * int k = 2;
     * Output : [5,2]
     * ===================Note===================
     * k값은 항상 주어짐
     */
    public static void main(String[] args) {
        MapArray mapArray = new MapArray();
        int[] nums = {1, 1, 2, 2, 2, 3, 5, 5, 5, 5};
        int k = 2;
        System.out.println("result ============ " + mapArray.topFrequent(nums, k));
    }

    @SuppressWarnings("unchecked")
    public List<Integer> topFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length];
        List<Integer> result = new ArrayList<>();

        // nums key 별로 횟수를 map 에 저장
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 10개의 list 중에 key 에 해당하는 인덱스는 arrayList 로 만들고 key 를 add
        for (int key : map.keySet()) {
            int topFrequent = map.get(key);
            if (list[topFrequent] == null) {
                list[topFrequent] = new ArrayList<>();
            }
            list[topFrequent].add(key);
        }

        for (int lastIndex = list.length - 1; lastIndex >= 0; lastIndex--) {
            if (list[lastIndex] != null) {
                for (int i = 0; i < list[lastIndex].size() && result.size() < k; i++) {
                    result.add(list[lastIndex].get(i));
                }
            }
        }

        return result;
    }
}

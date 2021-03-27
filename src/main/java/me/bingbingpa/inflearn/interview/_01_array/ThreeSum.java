package me.bingbingpa.inflearn.interview._01_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(Arrays.toString(threeSum.solution(new int[]{2, 3, 5, 7}, 10)));
    }

    /**
     * TODO 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 수 세개를 더해서 target 숫자를 만들 수 있는 인덱스를 찾는 함수를 작성하라.
     * 예) numbers = [2, 3, 5, 7] target = 10, 10을 만들 수 있는 2, 3, 5의 인덱스인 0, 1, 2를 배열로 리턴해야 한다.
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] solution(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int numberToFind = target - numbers[i] - numbers[j];

                if (numberMap.containsKey(numberToFind)) {
                    return new int[]{i, j, numberMap.get(numberToFind)};
                }
            }
        }
        return null;
    }
}

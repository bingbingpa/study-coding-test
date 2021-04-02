package me.bingbingpa.programmers.level1;

import java.util.*;

public class NumbersSumCase {
    public static void main(String[] args) {
        NumbersSumCase numbersSumCase = new NumbersSumCase();
//        int[] numbers = {2, 1, 3, 4, 1}; // [2,3,4,5,6,7]
        int[] numbers = {5, 0, 2, 7}; // [2,5,7,9,12]
        System.out.println("result ============= " + Arrays.toString(numbersSumCase.solution(numbers)));
    }

    /**
     * TODO 정수 배열 numbers 에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 오름차순으로 리턴하라.
     * 예) [5,0,2,7] ----> [2,5,7,9,12]
     */
    private int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private int[] solution2(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);

        return result;
    }
}

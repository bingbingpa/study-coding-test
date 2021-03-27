package me.bingbingpa.inflearn.interview._01_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.solution3(new int[]{1, 2, 2, 4, 5}));
    }

    /**
     * TODO 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 중복된 숫자가 있다면 true 없다면 false.
     * 예) 1 2 3 4 5 6 => false
     * 예) 1 1 2 2 3 1 => true
     */
    private boolean solution1(int[] numbers) {
//         시간 복잡도: O(n²)
//         공간 복잡도: O(1)
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solution2(int[] numbers) {
//        시간 복잡도: O(NlogN)
//        공간 복잡도: O(logN)

        Arrays.sort(numbers); // O(NlogN), O(logN)

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }

        return false;
    }

    private boolean solution3(int[] numbers) {
//        시간 복잡도: O(N)
//        공간 복잡도: O(N)
        Set<Integer> numberSet = new HashSet<>();

        for (int number : numbers) {
            if (numberSet.contains(number)) {
                return true;
            } else {
                numberSet.add(number);
            }
        }
        return false;
    }
}

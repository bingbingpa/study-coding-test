package me.bingbingpa.inflearn.interview._00_intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindUniqueNumber {
    /**
     * # 퀴즈 1) 유일한 숫자 찾기
     * numbers 라는 int 형 배열이 있다. 해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번씩 들어있다. 오직 한 번만 등장하는 숫자를 찾는 코드를 작성하라.
     */
    public static void main(String[] args) {
        FindUniqueNumber findUniqueNumber = new FindUniqueNumber();
        int result = findUniqueNumber.solution3(new int[]{1, 2, 2, 3, 3});
        System.out.println(result == 1);
    }

    /**
     * List를 만들고 배열에 있는 숫자를 순회하면서 해당 숫자가 List에 들어있는지 확인한다.
     * List에 들어있으면 List 에서 빼내고, 없으면 넣는다.
     * 그럼 결과적으로 List 에는 유일한 숫자만 들어있으니 해당 숫자를 꺼내서 리턴한다.
     *
     * 시간 복잡도: O(n) * O(n) => O(n²)
     * 공간 복잡도: O(n)
     */
    private int solution1(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (list.contains(num)) {
                list.remove((Integer) num);
            } else {
                list.add(num);
            }
        }

        return list.get(0);
    }

    /**
     * HashMap 을 사용해서 배열에 들어있는 숫자를 키, 숫자의 등장 횟수를 값으로 저장한다.
     * 숫자의 등장 횟수가 1인 키값을 찾아서 리턴한다.
     *
     * 시간 복잡도: O(n) + O(n) => O(2n) => O(n)
     * 공간 복잡도: O(n)
     */
    private int solution2(int[] numbers) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();

        for (int num : numbers) {
            numbersMap.put(num, numbersMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numbers) {
            if (numbersMap.get(num) == 1) {
                return num;
            }
        }

        return 0;
    }

    /**
     * XOR 비트 연산자 (^)를 사용하는 방법
     * XOR 비트 연산자: 두 비트가 서로 다를 때 1
     * 5 ^ 0 = 5
     *
     * 101
     * 000
     * ---
     * 101 => 5
     *
     * 5 ^ 5 = 0
     *
     * 101
     * 101
     * ---
     * 000 => 0
     *
     * 1 ^ 5 ^ 1 = (1 ^ 1) ^ 5 = 0 ^ 5 = 5
     *
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(1)
     *
     */
    private int solution3(int[] numbers) {
        int uniqueNum = 0;
        for (int num : numbers) {
            uniqueNum ^= num;
        }
        return uniqueNum;
    }

}

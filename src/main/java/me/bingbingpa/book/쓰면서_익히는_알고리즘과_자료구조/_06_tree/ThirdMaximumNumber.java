package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._06_tree;

import java.util.*;
import java.util.stream.Collectors;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println("result ============ " + solution1(new int[]{1, 2, 3})); // 1
        System.out.println("result ============ " + solution1(new int[]{2, 3})); // 3
        System.out.println("result ============ " + solution1(new int[]{1, 13, 2, 4, 7, 9, 10})); // 9
    }

    /**
     * TODO 배열에서 3번째로 큰 수를 찾아 반환하라. 만약 3번째로 큰 수가 없다면 가장 큰 수를 반환한다.
     */
    public static int solution1(int[] nums) {
        // 시긴 복잡도: O(nlogn)
        // 공간 복잡도: O(n)
        int cnt = 0;
        int thirdMax = 0;

        Set<Integer> checkDup = new HashSet<>();
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        Collections.reverse(list);
        thirdMax = list.get(0);

        for (int num : list) {
            if (checkDup.contains(nums)) {
                continue;
            }
            checkDup.add(num);
            if (cnt == 2) {
                thirdMax = num;
                break;
            }
            cnt++;
        }
        return thirdMax;
    }
}

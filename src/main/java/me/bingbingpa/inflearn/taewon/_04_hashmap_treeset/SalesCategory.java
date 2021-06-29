package me.bingbingpa.inflearn.taewon._04_hashmap_treeset;

import java.util.*;

public class SalesCategory {
//    public static void main(String[] args) {
//        SalesCategory T = new SalesCategory();
//        T.mySolution(new int[]{20, 12, 20, 10, 23, 17, 10}, 4);
//    }

    public static void main(String[] args) {
        SalesCategory T = new SalesCategory();
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[] arr = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr[i] = scanner.nextInt();
        }
        T.solution(arr, n2);
    }

    /**
     * TODO N 일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.
     */
    public void mySolution(int[] arr, int n) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int index = i;
            int count = 0;
            set.clear();
            while(count < n){
                set.add(arr[index++]);
                count++;
            }
            answer.add(set.size());
        }

        for (Integer num : answer) {
            System.out.printf(num + " ");
        }
    }

    public void solution(int[] arr, int n) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        int length = arr.length;
        for (int rt = n - 1; rt < length; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        for (Integer num : answer) {
            System.out.printf(num + " ");
        }
    }
}

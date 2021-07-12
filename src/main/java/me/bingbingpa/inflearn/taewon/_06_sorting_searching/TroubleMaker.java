package me.bingbingpa.inflearn.taewon._06_sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TroubleMaker {

//    public static void main(String[] args) {
//        TroubleMaker T = new TroubleMaker();
//        System.out.println(Arrays.toString(T.mySolution(new int[]{120, 125, 152, 130, 135, 135, 143, 127, 160})));
//    }

    public static void main(String[] args) {
        TroubleMaker T = new TroubleMaker();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : T.solution(arr)) {
            System.out.printf(i  + " ");
        }
    }

    /**
     * TODO 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를 차례로 출력하는 프로그램을 작성하세요.
     */
    public int[] mySolution(int[] arr) {
        int[] answer = new int[2];
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!flag && arr[i] > arr[i + 1]) {
                answer[0] = i + 1;
                flag = true;
            }
            if (flag && arr[i] < arr[i + 1]) {
                answer[1] = i + 1;
            }
        }
        return answer;
    }

    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i);
            }
        }
        return answer;
    }
}

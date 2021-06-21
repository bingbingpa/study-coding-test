package me.bingbingpa.inflearn.taewon._02_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrimes {

//    public static void main(String[] args) {
//        ReversePrimes T = new ReversePrimes();
//        int[] nums = new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100};
//        for (int num : T.mySolution(nums)) {
//            System.out.printf(num + " ");
//        }
//    }

    public static void main(String[] args) {
        ReversePrimes T = new ReversePrimes();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int x : T.solution(arr)) {
            System.out.printf(x + " ");
        }
    }

    /**
     * TODO N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
     */
    public List<Integer> solution(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            int reverseNum = reverseNumber(num);
            if (isPrime(reverseNum)) {
                answer.add(reverseNum);
            }
        }

        return answer;
    }

    private int reverseNumber(int num) {
        int result = 0;
        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

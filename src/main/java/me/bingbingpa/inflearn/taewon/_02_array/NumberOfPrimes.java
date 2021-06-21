package me.bingbingpa.inflearn.taewon._02_array;

import java.util.Scanner;

public class NumberOfPrimes {

//    public static void main(String[] args) {
//        NumberOfPrimes T = new NumberOfPrimes();
//        System.out.println(T.solution(20));
//    }

    public static void main(String[] args) {
        NumberOfPrimes T = new NumberOfPrimes();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(T.solution(num));
    }

    /**
     * TODO 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.(에라토스네테스 체)
     * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
     */
    public int solution(int num) {
        int answer = 0;
        int[] ch = new int[num + 1];
        for (int i = 2; i <= num; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= num; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }
}

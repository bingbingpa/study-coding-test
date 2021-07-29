package me.bingbingpa.programmers.level1;

public class CollatzGuess {

    public static void main(String[] args) {
        CollatzGuess T = new CollatzGuess();
        System.out.println(T.solution(626331));
//        6	8
//        16	4
//        626331	-1
    }

    /**
     * TODO  작업을 몇 번이나 반복해야하는지 반환하는 함수를 작성하라.
     * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
     * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
     * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
     */
    public int solution(int n) {
        long num = n;
        int count = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;

            if (count > 500)
                return -1;
        }

        return count;
    }
}

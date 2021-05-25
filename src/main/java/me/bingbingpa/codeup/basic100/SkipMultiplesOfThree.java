package me.bingbingpa.codeup.basic100;

public class SkipMultiplesOfThree {
    public static void main(String[] args) {
        solution(10);
    }

    /**
     * TODO 1부터 입력한 정수까지 1씩 증가시켜 출력하는 프로그램을 작성하되, 3의 배수인 경우는 출력하지 않도록 만들어보자.
     */
    public static void solution(int num) {
        for (int i = 1; i < num + 1; i++) {
            if (i % 3 != 0) {
                System.out.printf(i + " ");
            }
        }
    }
}

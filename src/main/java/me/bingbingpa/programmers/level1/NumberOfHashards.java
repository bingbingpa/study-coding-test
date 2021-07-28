package me.bingbingpa.programmers.level1;

public class NumberOfHashards {
    public static void main(String[] args) {
        NumberOfHashards T = new NumberOfHashards();
        System.out.println(T.solution(10));
    }

    /**
     * TODO 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution 을 완성하라.
     * https://programmers.co.kr/learn/courses/30/lessons/12947
     */
    public boolean solution(int x) {
        String str = String.valueOf(x);
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += ch - '0';
        }

        return x % sum == 0;
    }
}

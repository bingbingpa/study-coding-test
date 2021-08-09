package me.bingbingpa.programmers.level1;

public class NumberOfDivisor {
    public static void main(String[] args) {
        NumberOfDivisor T = new NumberOfDivisor();
        System.out.println(T.solution(13, 17)); // 43
    }

    /**
     * 약수의 개수와 덧셈
     * https://programmers.co.kr/learn/courses/30/lessons/77884
     */
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            boolean plus = isPlush(i);
            if (plus) {
                answer+= i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public boolean isPlush(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count % 2 == 0;
    }
}

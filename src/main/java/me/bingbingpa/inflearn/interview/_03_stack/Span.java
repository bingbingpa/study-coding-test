package me.bingbingpa.inflearn.interview._03_stack;

import java.util.Arrays;
import java.util.Stack;

public class Span {
    public static void main(String[] args) {
        Span span = new Span();
        System.out.println(Arrays.toString(span.solution(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(span.solution(new int[]{2, 3, 4, 5, 6, 7})));
    }

    /**
     * TODO 주어진 배열 prices 에 대한 스팬을 구하는 코드를 작성하라.
     *  스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.
     *  예) [5, 3, 2, 4, 7, 1]    =>   [1, 1, 1, 3, 5, 1]
     *  예) [2, 3, 4, 5, 6, 7]    =>   [1, 2, 3, 4, 5, 6]
     */
    private int[] solution(int[] price) {
        int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return span;
    }
}

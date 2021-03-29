package me.bingbingpa.inflearn.interview._03_stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        System.out.println(numbers);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.solution2(numbers);
        System.out.println(numbers);
    }

    // TODO 스택을 뒤집는 코드를 작성하라.
    private Stack<Integer> solution1(Stack<Integer> stack) {
//        시간 복잡도: O(N)
//        공간 복잡도: O(N)
        Stack<Integer> reversed = new Stack<>();
        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }

        return reversed;
    }

    private void solution2(Stack<Integer> stack) {
//        시간 복잡도: O(N²)
//        공간 복잡도: O(N)
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        solution2(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int number) {
        if (stack.isEmpty()) {
            stack.push(number);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, number);
            stack.push(temp);
        }
    }
}

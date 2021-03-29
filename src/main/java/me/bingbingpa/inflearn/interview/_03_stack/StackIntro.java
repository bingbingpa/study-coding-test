package me.bingbingpa.inflearn.interview._03_stack;

import java.util.Stack;

public class StackIntro {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        System.out.println(numbers.peek());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
    }
}

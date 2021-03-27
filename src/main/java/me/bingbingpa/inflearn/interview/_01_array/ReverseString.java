package me.bingbingpa.inflearn.interview._01_array;

import me.bingbingpa.inflearn.basic.ch01.CharAt;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.solution2("Hello".toCharArray()));
    }

    /**
     * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     *  예) hello => olleh
     *  예) happy new year => reay wen yppah
     *
     * @param message
     * @return
     */
    private char[] solution1(char[] message) {
//        시간 복잡도: O(N)
//        공간 복잡도: O(N)
        char[] reverseMessage = new char[message.length];

        // 4 - 4 -> 0
        // 4 - 3 -> 1
        // 4 - 2 -> 2
        // 4 - 1 -> 3
        // 4 - 0 -> 4
        for (int i = message.length - 1; i >= 0; i--) {
            reverseMessage[message.length - 1 - i] = message[i];
        }

        return reverseMessage;
    }

    private char[] solution2(char[] message) {
//        시간 복잡도: O(N)
//        공간 복잡도: O(1)
        for (int i = 0; i < message.length / 2; i++) {
            char temp = message[i];
            message[i] = message[message.length - 1 - i];
            message[message.length - 1 - i] = temp;
        }
        return message;
    }
}

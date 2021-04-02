package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] array = {0, 3, 2, 0, 8, 5};
        System.out.println("result =================== " + Arrays.toString(moveZeros.solve(array)));
    }

    /**
     * TODO 배열 num 을 감안할 때 0 이 아닌 요소의 상대적인 순서를 유지하면서 모든 0 을 끝으로 이동 시키는 함수를 작성하라.
     * 예) Input: [0,3,2,0,8,5]
     * Output: [3,2,8,5,0,0]
     */
    private int[] solve(int[] array) {
        int length = array.length;
        int[] result = new int[length];
        int index = 0;
        for (int num : array) {
            if (num != 0) {
                result[index] = num;
                index++;
            }
        }

        while (index < length) {
            result[index] = 0;
            index++;
        }

        return result;
    }
}

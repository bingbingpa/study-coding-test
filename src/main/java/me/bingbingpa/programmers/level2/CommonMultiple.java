package me.bingbingpa.programmers.level2;

public class CommonMultiple {

    public static void main(String[] args) {
        CommonMultiple T = new CommonMultiple();
        System.out.println(T.solution(new int[]{2, 6, 8, 14}));
    }

    /**
     * N 개의 최소공배수
     * https://programmers.co.kr/learn/courses/30/lessons/12953
     */
    public int solution(int[] arr) {
        int number = arr[arr.length - 1];
        while (!isValid(arr, number)) {
            number++;
        }
        return number;
    }

    private boolean isValid(int[] arr, int num) {
        for (int n : arr) {
            if (num % n != 0) {
                return false;
            }
        }
        return true;
    }
}

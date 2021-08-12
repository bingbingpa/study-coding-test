package me.bingbingpa.programmers.level2;

public class NextBigNumber {

    public static void main(String[] args) {
        NextBigNumber T = new NextBigNumber();
        System.out.println(T.solution(78));
    }

    /**
     * 다음 큰 숫자
     * https://programmers.co.kr/learn/courses/30/lessons/12911
     */
    public int solution(int n) {
        int source = findOne(Integer.toBinaryString(n));
        int target = findOne(Integer.toBinaryString(++n));
        while (source != target) {
            target = findOne(Integer.toBinaryString(++n));
        }

        return n;
    }

    public int findOne(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}

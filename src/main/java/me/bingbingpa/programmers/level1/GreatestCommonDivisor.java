package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        GreatestCommonDivisor T = new GreatestCommonDivisor();
        System.out.println(Arrays.toString(T.solution(2, 5)));
    }

    /**
     * TODO 최대 공약수와 최소 공배수를 리턴하라.
     */
    public int[] solution(int n, int m) {
        return new int[]{gcd(n, m), lcm(n, m)};
    }

    // 최대 공약수
    public int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소 공배수
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}

package me.bingbingpa.codeup.recursion;

public class HailstoneSequence {
    public static void main(String[] args) {
        solution(5); // output: 5  → 16 → 8 → 4 → 2 → 1
    }

    /**
     * TODO 자연수 n이 입력되면 콜라주의 추측 알고리즘에 의해 1이 되는 과정을 모두 출력하시오.
     * 어떤 자연수 n이 입력되면, n이 홀수이면 3n+1을 하고, n이 짝수이면 n2를 한다. n이 1이 될때까지 이러한 과정을 반복한다.
     * 예를 들어 5는 5 → 16 → 8 → 4 → 2 → 1 이 된다.
     * 자연수 n이 입력된다.(1<=n<=10,000,000)
     * 단, 3n+1이 되는 과정에서 int 범위를 넘는 수는 입력으로 주어지지 않는다.
     */
    public static void solution(int num) {
        System.out.println(num);
        if (num == 1) {
            return;
        }
        int result = num % 2 != 0 ? 3 * num + 1 : num / 2;
        solution(result);
    }
}

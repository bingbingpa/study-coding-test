package me.bingbingpa.codeup.recursion;

public class BinaryConversion {
    public static void main(String[] args) {
        System.out.println("result ============= " + solution(0)); // output: 111
    }

    /**
     * TODO 어떤 10진수 n이 주어지면 재귀를 사용하여 2진수로 변환해서 출력하시오.
     * 10진수 정수 n이 입력된다. (0<=n<=2,100,000,000)
     */
    public static String  solution(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        recursion(num, sb);
        return sb.reverse().toString();
    }

    private static void recursion(int num, StringBuilder sb) {
        if (num == 1) {
            sb.append("1");
            return;
        }
        if (num == 0) {
            return;
        }
        char divide = num % 2 == 0 ? '0' : '1';
        sb.append(divide);
        recursion(num / 2, sb);
    }
}

package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._02_string;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("result ========== " + solution("Abbc,c,bb,a")); // true
//        System.out.println("result ========== " + solution(", ,--")); // true
//        System.out.println("result ========== " + solution("Abbc,cdda")); // false
    }

    /**
     * TODO 주어진 문자열이 회문인지 아닌지 확인하라.
     * 회문(바로 읽거나 거꾸로 읽어도 같은 말이나 구절이 되는 것)으로 확인해야 하는 문자는 알파벳과 숫자이며, 알파벳은 대/소문자를 구분하지 않는다.
     * 예) input: "Abbc,c,bb,a", output: true
     */
    public static boolean solution(String str) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        int i = 0;
        int j = str.length() - 1;

        str = str.toLowerCase();

        while (i < j) {
            while (i < j) {
                if (isalnum(str.charAt(i))) {
                    break;
                }
                i++;
            }

            while (i < j) {
                if (isalnum(str.charAt(j))) {
                    break;
                }
                j--;
            }

            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isalnum(char ch) {
        return String.valueOf(ch).matches("^[a-zA-Z0-9]*$");
    }
}

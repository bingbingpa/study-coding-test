package me.bingbingpa.inflearn.basic._05_sort;

public class SortCompareTo {
    /**
     * ===================Problem===================
     * - 버전 번호를 version1하고 version2, 비교한다.
     * 다음을 반환합니다.
     * version1 < version2 이면 -1 반환
     * version1 > version2 이면 1 반환
     * 그렇지 않으면을 0반환.
     * ===================Example===================
     * Input: String version1 = "8.5.2.4",
     * version2 = "8.5.3";
     * Output: -1
     * ===================Note===================
     * Integer a =1, b=3;
     * // 오름차순 -1, 오른쪽 큰값
     * a.compareTo(b);//-1
     */
    public static void main(String[] args) {
//        String version1 = "8.5.2.4";
//        String version2 = "8.5.3";
        String version1 = "1.0.1";
        String version2 = "1";
//        compareToTest();
        System.out.println("result ============== "+ solve(version1, version2));

    }

    public static int solve(String v1, String v2) {
        String[] v1StrArray = v1.split("\\.");
        String[] v2StrArray = v2.split("\\.");

        int length = Math.max(v1StrArray.length, v2StrArray.length);
        for (int i = 0; i < length; i++) {
            Integer num1 = i < v1StrArray.length ? Integer.parseInt(v1StrArray[i]) : 0;
            Integer num2 = i < v2StrArray.length ? Integer.parseInt(v2StrArray[i]) : 0;

            int compare = num1.compareTo(num2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    public static void compareToTest() {
        Integer a = 1;
        Integer b = 3;
        System.out.println(a.compareTo(b));
    }
}

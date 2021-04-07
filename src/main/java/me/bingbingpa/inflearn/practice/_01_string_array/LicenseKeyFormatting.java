package me.bingbingpa.inflearn.practice._01_string_array;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println("result =============== " + licenseKeyFormatting.solution("8F3Z-2e-9-w", 4));
    }

    /**
     * TODO 주어진 문자열을 '-' 를 제거하고 k 번째를 기준으로 표시하라.
     * 예) input: 8F3Z-2e-9-w, k=4, output: 8F3Z-2E9W
     */
    public String solution(String str, int k) {
        StringBuilder builder = new StringBuilder();
        String newStr = str.replace("-", "");
        newStr = newStr.toUpperCase();
        int length = newStr.length();

        for (int i = 0; i < length; i++) {
            builder.append(newStr.charAt(i));
        }

        for (int i = k; i < length; i = i + k) {
            builder.insert(length - i, '-');
        }

        return builder.toString();
    }
}

package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._02_string;

public class ValidateIpAddress {
    public static void main(String[] args) {
        System.out.println(solution1("172.2.10.1")); // IPv4
        System.out.println(solution1("172.2.10.01")); // Neither
        System.out.println(solution1("2020:0bc3:0000:0000:853e:0777:1234:0000")); // IPv6
        System.out.println(solution1("2020:0bc3:::853e:0777:1234")); // Neither
    }

    /**
     * TODO 입력으로 받은 문자열이 유효한 IPv4 인지, IPv6 인지 확인하는 함수를 작성하라.
     */
    public static String solution1(String IP) {
        // 시간 복잡도: O(L) L 은 입력 문자열 길이
        // 공간 복잡도: O(1)
        if (count(IP, ".") == 3) {
            return checkIpV4(IP);
        } else if (count(IP, ":") == 7) {
            return checkIpV6(IP);
        }
        return "Neither";
    }

    public static String solution2(String IP) {
        // 시간 복잡도: O(1)
        // 공간 복잡도: O(1)
        String ipv4Regex = "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}";
        String ipv6Regex = "^(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))$";

        if (IP.matches(ipv4Regex)) {
            return "IPv4";
        }

        if (IP.matches(ipv6Regex)) {
            return "IPv6";
        }

        return "Neither";
    }

    private static String checkIpV4(String ipv4) {
        String[] ipNums = ipv4.split("\\.");
        for (String ipNum : ipNums) {
            int length = ipNum.length();
            if (length == 0 || length > 3) {
                return "Neither";
            }
            if ((length != 1 && ipNum.charAt(0) == '0') || !isDigit(ipNum) || Integer.parseInt(ipNum) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private static String checkIpV6(String ipv6) {
        String[] ipNums = ipv6.split(":");
        for (String ipNum : ipNums) {
            int length = ipNum.length();
            if (length == 0 || length > 4 || !hexdigits(ipNum)) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    private static boolean isDigit(String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hexdigits(String str) {
        String regex = "[0-9a-fA-F]";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!String.valueOf(ch).matches(regex)) {
                return false;
            }
        }
        return true;
    }

    private static int count(String str, String target) {
        return str.length() - str.replace(target, "").length();
    }
}

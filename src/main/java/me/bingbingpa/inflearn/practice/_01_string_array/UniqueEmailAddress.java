package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };
        System.out.println("result ================ " + uniqueEmailAddress.solution1(emails));
    }

    /**
     * TODO 유니크한 이메일의 개수를 리턴하라.
     */
    public int solution1(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.contains("+") ? email.indexOf("+") : email.length();
            String address = email
                    .substring(0, index)
                    .replace(".", "");
            String domain = email.substring(email.indexOf("@"));
//            System.out.println("address =========== " + address);
//            System.out.println("domain =========== " + domain);
            set.add(address.concat(domain));
        }

        return set.size();
    }

    public int solution2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }

    private String makeLocalName(String email) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                continue;
            }
            if (email.charAt(i) == '+' || email.charAt(i) =='@') {
                break;
            }
            String str = String.valueOf(email.charAt(i));
            builder.append(str);
        }

        return builder.toString();
    }

    private String makeDomainName(String email) {
        return email.substring(email.indexOf('@')+1);
    }
}

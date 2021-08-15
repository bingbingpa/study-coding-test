package me.bingbingpa.programmers.level2;

public class PhoneNumbers {

    public static void main(String[] args) {
        PhoneNumbers T = new PhoneNumbers();
        System.out.println(T.solution(new String[]{"123", "456", "789"})); //true
    }

    /**
     * 전화번호 목록
     * https://programmers.co.kr/learn/courses/30/lessons/42577
     */
    public boolean solution(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[i].startsWith(phoneBook[j])) {
                    return false;
                }
                if (phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}

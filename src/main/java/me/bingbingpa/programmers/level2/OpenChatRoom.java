package me.bingbingpa.programmers.level2;

import java.util.*;

public class OpenChatRoom {

    public static void main(String[] args) {
        OpenChatRoom T = new OpenChatRoom();
        String[] record = new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
        };
        System.out.println(T.solution(record));
    }

    /**
     * 오픈 채팅방
     * https://programmers.co.kr/learn/courses/30/lessons/42888
     * @return
     */
    public List<String> solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] split = s.split(" ");
            if(!split[0].equals("Leave")){
                map.put(split[1], split[2]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String s : record) {
            String[] split = s.split(" ");
            String type = split[0];
            if ("Enter".equals(type)) {
                result.add(map.get(split[1]) + "님이 들어왔습니다.");
            }
            if ("Leave".equals(type)) {
                result.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }

        return result;
    }
}

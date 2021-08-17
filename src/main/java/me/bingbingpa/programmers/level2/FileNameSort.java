package me.bingbingpa.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileNameSort {

    public static void main(String[] args) {
        FileNameSort T = new FileNameSort();
        System.out.println(Arrays.toString(T.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

    /**
     * 파일명 정렬
     * https://programmers.co.kr/learn/courses/30/lessons/17686
     */
    public String[] solution(String[] files) {
        List<FileName> fileNameList = new ArrayList<>();
        for (String file : files) {
            fileNameList.add(new FileName(file));
        }
        Collections.sort(fileNameList);
        for(int i = 0; i < files.length; i++) {
            files[i] = fileNameList.get(i).getFileName();
        }
        return files;
    }

    static class FileName implements Comparable<FileName> {
        String name;
        String head;
        int number;
        String tail;

        public FileName(String name) {
            int[] number = findNumber(name);
            this.name = name;
            this.head = name.substring(0, number[0] - 1);
            this.number = Integer.parseInt(name.substring(number[0], number[1]));
            this.tail = name.substring(number[1]);
        }

        public String getFileName() {
            return name;
        }

        @Override
        public int compareTo(FileName o) {
            if (!head.equalsIgnoreCase(o.head)) {
                return head.compareToIgnoreCase(o.head);
            }
            return number - o.number;
        }

        private int[] findNumber(String str) {
            int[] answer = new int[2];
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                if (!flag && Character.isDigit(str.charAt(i))) {
                    answer[0] = i;
                    flag = true;
                }
                if (flag && !Character.isDigit(str.charAt(i))) {
                    answer[1] = i;
                    break;
                }
            }

            return answer;
        }
    }
}

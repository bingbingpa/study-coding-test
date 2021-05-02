package me.bingbingpa.inflearn.practice._04_graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String[] words = {"hot", "dot", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println("result ================ " + wordLadder.solution("hit", "cog", wordList));
    }

    /**
     * TODO 시작 문자에서 한글자씩만 바꿔서 문자리스트에 있는 문자들을 통해 끝문자인 cog 로 변경되는데까지의 횟수를 구하시오.
     * 예) input: beginWord = "hit", endWord = "cog", wordList=["hot","dot","dog","lot","log","cog"], output: 5 ("hit"->"hot"->"dot"->"dog"->"cog"
     */
    public int solution(String beginWord, String endWord, List<String> wordList){
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) {
                    return level;
                }
                for (String neighbor : neighbors(str, wordList)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> neighbors(String s, List<String> wordList) {
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if (dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}

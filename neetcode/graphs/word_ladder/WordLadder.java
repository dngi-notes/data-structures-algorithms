package neetcode.graphs.word_ladder;

import java.util.*;

public class WordLadder {
    /*
     * A transformation sequence from word beginWord to word endWord using a
     * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
     * such that:
     * 
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
     * be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList, return the
     * number of words in the shortest transformation sequence from beginWord to
     * endWord, or 0 if no such sequence exists.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        if(!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> graph = new HashMap<>();
        int len = beginWord.length();

        for(String word: wordList) {
            for(int i = 0; i < len; i++) {
                String pattern = word.substring(0, i) + '#' + word.substring(i + 1);
                graph.computeIfAbsent(pattern, key -> new ArrayList<>()).add(word);
            }
        }

        // queue of map for word to transformation level
        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            Map.Entry<String, Integer> current = queue.poll();
            String currentWord = current.getKey();
            int level = current.getValue();

            for(int i = 0; i < len; i++) {
                String pattern = currentWord.substring(0, i) + '#' + currentWord.substring(i + 1);
                for(String adjacentWord: graph.getOrDefault(pattern, new ArrayList<>())) {
                    if(adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    if(!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.offer(new AbstractMap.SimpleEntry<>(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
